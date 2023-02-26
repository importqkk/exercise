package com.exercise.exPage.service;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.exercise.exPage.configuration.FileProperties;
import com.exercise.exPage.dao.AttachmentDao;
import com.exercise.exPage.dao.BoardDao;
import com.exercise.exPage.dao.BoardImgDao;
import com.exercise.exPage.dto.AttachmentDto;
import com.exercise.exPage.dto.BoardDto;
import com.exercise.exPage.dto.BoardImgDto;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardImgDao boardImgDao;
	@Autowired
	private AttachmentDao attachmentDao;
	@Autowired
	private FileProperties props;
	
	private File dir;
	@PostConstruct
	public void init() {
		dir = new File(props.getPath());
		dir.mkdirs();
	}
	
	// boardDto의정보를 새 글과 답글로 구분하여 처리후 등록
	// - 새글일 경우 boardParent가 null
	// 		- 그룹번호(boardGroup)는 글번호와 동일하게 처리
	//		- 대상글번호(boardParent)는 null로 설정
	//		- 차수(boardDepth)는 0으로 설정
	// - 답글일 경우 boardParent가 null이 아님: 대상글의 정보를 조회한 결과를 이용하여 설정
	// 		- 그룹번호(boardGroup)는 대상글의 그룹번호와 동일하게 처리
	//		- 대상글번호(boardParent)는 전달받은 값을 그대로 사용
	// 		- 차수(boardDepth)는 대상글의 차수에 1을 더해서 사용
	public int post(BoardDto boardDto, MultipartFile attach) throws IllegalStateException, IOException {
		
		// 글 번호 구하기
		int boardNo = boardDao.sequence();
		boardDto.setBoardNo(boardNo);
		
		// 새글이라면
		if(boardDto.isNew()) {
			boardDto.setBoardGroup(boardNo);
		}
		// 답글이라면
		else {
			BoardDto parentDto = boardDao.detail(boardDto.getBoardParent());
			boardDto.setBoardGroup(parentDto.getBoardGroup());
			boardDto.setBoardDepth(parentDto.getBoardDepth()+1);
		}
		// 게시글등록
		boardDao.post(boardDto);
		
		// 첨부파일 처리
		if(!attach.isEmpty()) {
			int attchmentNo = attachmentDao.sequence();
			File target = new File(dir, String.valueOf(attchmentNo));
			attach.transferTo(target);
			
			attachmentDao.insert(AttachmentDto.builder()
						.attachmentNo(attchmentNo)
						.attachmentName(attach.getOriginalFilename())
						.attachmentType(attach.getContentType())
						.attachmentSize(attach.getSize())
					.build());
			boardImgDao.post(BoardImgDto.builder()
						.boardNo(boardDto.getBoardNo())
						.attachmentNo(attchmentNo)
					.build());
		}
		
		// 게시글 번호 반환
		return boardNo;
		
	}
	
}
