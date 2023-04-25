package com.exercise.exPage.service;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.exercise.exPage.dao.AttachmentDao;
import com.exercise.exPage.dao.LectureImgDao;
import com.exercise.exPage.dto.AttachmentDto;
import com.exercise.exPage.dto.LecturesDto;
import com.exercise.exPage.repository.LectureRepository;
import com.exercise.exPage.dto.LectureImgDto;

@Service
public class LecturesService {

//	@Autowired
//	private LecturesDao lecturesDao;
	@Autowired
	private LectureRepository lectureRepository;
	@Autowired
	private LectureImgDao lectureImgDao;
	@Autowired
	private AttachmentDao attachmentDao;

	// 업로드 위치 설정
	private final File dir = new File("C:/Users/KBCARD/Desktop/sts_workspace/upload");
	// 폴더 생성 명령
	@PostConstruct
	public void init() {
		dir.mkdirs();
	}
	
	public void add(LecturesDto lecturesDto, MultipartFile attach) throws IllegalStateException, IOException {
		// [1] 강의 등록
		// 번호 생성
//		int lectureNo = lectureRepository.selectOne();
		// 생성한 번호 넣기
//		lecturesDto.setLecturesNo(lectureNo);
		// 등록
		lectureRepository.insert(LecturesDto.builder()
//					.lecturesNo(lectureNo)
					.lecturesNo(lecturesDto.getLecturesNo())
					.lecturesLecture(lecturesDto.getLecturesLecture())
					.lecturesLecturer(lecturesDto.getLecturesLecturer())
					.lecturesHours(lecturesDto.getLecturesHours())
					.lecturesFee(lecturesDto.getLecturesFee())
				.build());
		// [2] (사진을 등록했을 시)사진 저장 및 등록
		if(!attach.isEmpty()) {
			// 번호 생성
			int attachmentNo = attachmentDao.sequence();
			// 파일 이름 설정
			File target = new File(dir, String.valueOf(attachmentNo));
			attach.transferTo(target);
			// DB 저장
			attachmentDao.insert(AttachmentDto.builder()
						.attachmentNo(attachmentNo)
						.attachmentName(attach.getOriginalFilename())
						.attachmentType(attach.getContentType())
						.attachmentSize(attach.getSize())
					.build());
			// [3] 강의번호와 사진(첨부파일) 번호 연결
			lectureImgDao.insert(LectureImgDto.builder()
						.lectureNo(lecturesDto.getLecturesNo())
						.attachmentNo(attachmentNo)
					.build());
		}
	}
	
}
