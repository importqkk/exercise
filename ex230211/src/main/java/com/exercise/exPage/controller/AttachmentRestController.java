package com.exercise.exPage.controller;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.annotation.PostConstruct;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.exercise.exPage.configuration.FileProperties;
import com.exercise.exPage.dao.AttachmentDao;
import com.exercise.exPage.dto.AttachmentDto;

@RestController
@CrossOrigin
@RequestMapping("/rest/attachment")
public class AttachmentRestController {

	@Autowired
	private AttachmentDao attachmentDao;
	@Autowired
	private FileProperties fileProperties;
	
	private File dir;
	@PostConstruct
	public void init() {
		dir = new File(fileProperties.getPath());
		dir.mkdirs();
	}
	
	// 업로드(등록)
	@PostMapping("/upload")
	public AttachmentDto upload(@RequestParam MultipartFile attachment) throws IllegalStateException, IOException {
		if(!attachment.isEmpty()) {
			int attachmentNo = attachmentDao.sequence();
			File target = new File(dir, String.valueOf(attachmentNo));
			attachment.transferTo(target);
			attachmentDao.insert(AttachmentDto.builder()
						.attachmentNo(attachmentNo)
						.attachmentName(attachment.getOriginalFilename())
						.attachmentType(attachment.getContentType())
						.attachmentSize(attachment.getSize())
					.build());
			return attachmentDao.selectOne(attachmentNo);
		}
		return null;
	}
	
	// 다운로드
	@GetMapping("/download/{attachmentNo}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable int attachmentNo) throws IOException {
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);	// 헤더
		if(attachmentDto == null) {	// 파일이 없음
			return ResponseEntity.notFound().build();	// 없으면 notFound
		}
		// 있으면 파일 찾기
		File target = new File(dir, String.valueOf(attachmentNo));
		// 보낼 데이터 생성
		byte[] data = FileUtils.readFileToByteArray(target);	// 바디
		ByteArrayResource resource = new ByteArrayResource(data);
		// 헤더와 바디를 설정하며 ResponseEntity를 만들어 반환
		// 제공되는 모든 상수와 명령을 동원해서 최대한 오류 없이 편하게 작성
		return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_OCTET_STREAM)
					.contentLength(attachmentDto.getAttachmentSize())
					.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
					.header(HttpHeaders.CONTENT_DISPOSITION, 
								ContentDisposition.attachment().filename(
									attachmentDto.getAttachmentName(), 
									StandardCharsets.UTF_8
								).build().toString()
							)
				.body(resource);
	}
}
