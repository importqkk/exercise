package com.exercise.exPage.service;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.exercise.exPage.dao.AttachmentDao;
import com.exercise.exPage.dao.MembersDao;
import com.exercise.exPage.dao.MembersImgDao;
import com.exercise.exPage.dto.AttachmentDto;
import com.exercise.exPage.dto.MembersDto;
import com.exercise.exPage.dto.MembersImgDto;

@Service
public class MembersService {

	@Autowired
	private MembersDao membersDao;
	@Autowired
	private MembersImgDao membersImgDao;
	@Autowired
	private AttachmentDao attachmentDao;
	
	// 위치 설정
	private final File dir = new File("C:/Users/KBCARD/Desktop/sts_workspace/upload");
	
	// 폴더 생성
	@PostConstruct
	public void init() {
		dir.mkdirs();
	}
	
	public void join(MembersDto membersDto, MultipartFile attach) throws IllegalStateException, IOException {
		
		// [1] 회원 가입
		membersDao.join(membersDto);
		
		// [2] 프사 저장 및 등록 (프사 설정 안했을 시 건너 뜀)
		if(!attach.isEmpty()) {
			// 번호 생성
			int attachmentNo = attachmentDao.sequence();
			// 파일 이름 설정
			File target = new File(dir, String.valueOf(attachmentNo));
			attach.transferTo(target);
			// db 저장
			attachmentDao.insert(AttachmentDto.builder()
						.attachmentNo(attachmentNo)
						.attachmentName(attach.getOriginalFilename())
						.attachmentType(attach.getContentType())
						.attachmentSize(attach.getSize())
					.build());
			// [3] 회원 아이디와 첨부파일 번호 연결
			membersImgDao.insert(MembersImgDto.builder()
						.memberID(membersDto.getMemberID())
						.attachmentNo(attachmentNo)
					.build());
		}
	}

}
