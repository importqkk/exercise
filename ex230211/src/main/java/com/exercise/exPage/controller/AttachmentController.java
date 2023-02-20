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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.exercise.exPage.configuration.FileProperties;
import com.exercise.exPage.dao.AttachmentDao;
import com.exercise.exPage.dto.AttachmentDto;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

	@Autowired
	private FileProperties props;
	private File dir;
	@PostConstruct
	public void init() {
		dir = new File(props.getPath());
	}
	
	@Autowired
	private AttachmentDao attachmentDao;
	
	// 파일 다운로드
	@GetMapping("/download")
	public ResponseEntity<ByteArrayResource> download(@RequestParam int attachmentNo) throws IOException {
		// DB 조회
		AttachmentDto attachmentDto = attachmentDao.selectOne(attachmentNo);
		// 파일이 없으면
		if(attachmentDto == null) {
			return ResponseEntity.notFound().build();
		}	
		// 파일이 있으면 파일 찾기
		File target = new File(dir, String.valueOf(attachmentNo));
		// 보낼 데이터 생성
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource resource = new ByteArrayResource(data);
		// 헤더와 바디 설정
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(attachmentDto.getAttachmentSize())
				.header(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name())
				.header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(
						attachmentDto.getAttachmentName(), StandardCharsets.UTF_8)
						.build().toString()
				)
				.body(resource);
	}
	
	
}
