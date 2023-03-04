package com.exercise.exPage.controller;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.exercise.exPage.dao.BoardDao;
import com.exercise.exPage.dao.BoardImgDao;
import com.exercise.exPage.dto.BoardDto;
import com.exercise.exPage.service.BoardService;
import com.exercise.exPage.vo.PageVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardImgDao boardImgDao;
	
	// 게시글 등록
	@GetMapping("/post")
	public String post(Model model, 
			@RequestParam(required = false) Integer boardParent) {
		model.addAttribute("boardParent", boardParent);
		return "/WEB-INF/views/board/post.jsp";
	}
	@PostMapping("/post")
	public String post(HttpSession session, RedirectAttributes attr,
			@ModelAttribute BoardDto boardDto,
			@RequestParam MultipartFile attach) throws IllegalStateException, IOException {
		String memberID = (String)session.getAttribute("memberID");
		boardDto.setBoardWriter(memberID);
		int boardNo = boardService.post(boardDto, attach);
		attr.addAttribute("boardNo", boardNo);
		return "redirect:detail";
	}
	
	// 게시글 상세보기
	@GetMapping("/detail")
	public String detail(Model model, HttpSession session,
			@RequestParam int boardNo) {
		// 해당 번호의 게시글 정보 모두 불러오기
		BoardDto boardDto = boardDao.detail(boardNo);
		// 글 수정 버튼은 작성자 본인에게만, 삭제 버튼은 관리자와 작성자 본인에게만 보이도록 jsp에 방문자 정보 전달
		// 상세보기를 클릭한 사용자가 해당 글의 작성자인지 판단
		String memberID = (String)session.getAttribute("memberID");
		boolean owner = boardDto.getBoardWriter() != null && boardDto.getBoardWriter().equals(memberID);
		model.addAttribute("owner", owner);
		// 관리자인지 판단
		String memberLevel = (String)session.getAttribute("memberLevel");
		boolean admin = memberLevel != null && memberLevel.equals("admin");
		model.addAttribute("admin", admin);
		// 조회수
		// 증가 조건 1: 내가 쓴 글이 아님
		if(!owner) {
			// 조회한 글을 세션에서 기억하게 하기
			Set<Integer> memory = (Set<Integer>)session.getAttribute("memory");
			if(memory == null) {
				memory = new TreeSet<>();
			}
			// 증가 조건 2: 이전에 읽은 글이 아님 (단, 세션 내에서)
			// 세션에 저장된 읽은 글 목록에 현재 글이 없다면
			// 조회수 증가시키고 읽은 글 목록에 현재 글 추가
			if(!memory.contains(boardNo)) {
				boardDao.updateView(boardNo);
				boardDto.setBoardView(boardDto.getBoardView()+1);
				memory.add(boardNo);
			}
			session.setAttribute("memory", memory);
		}
		model.addAttribute("boardDto", boardDto);
		model.addAttribute("image", boardImgDao.detail(boardNo));
		return "/WEB-INF/views/board/detail.jsp";
	}
	
	// 게시글 목록
	@GetMapping("/list")
	public String list(Model model, @ModelAttribute("vo") PageVO vo) {
		// 게시글 개수 구하고 vo에 넣어주기
		int totalCount = boardDao.listCount(vo);
		vo.setCountTotalData(totalCount);
		// 상단 고정할 공지 목록 (가장 최근 5개)
		model.addAttribute("noticeList", boardDao.noticeList(1, 5));
		// 게시글 목록
		List<BoardDto> list = boardDao.list(vo);
		model.addAttribute("list", list);
		return "/WEB-INF/views/board/list.jsp";
	}
	
	// 게시글 수정
	@GetMapping("/edit")
	public String edit(Model model,
			@RequestParam int boardNo) {
		model.addAttribute("boardDto", boardDao.detail(boardNo));
		return "/WEB-INF/views/board/edit.jsp";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto,
			@RequestParam MultipartFile attach,
			RedirectAttributes attr) throws IllegalStateException, IOException {
		boardDao.edit(boardDto);
		
		if(!attach.isEmpty()) {
			boardService.delete(boardDto.getBoardNo());
		}
		boardService.edit(boardDto, attach);
			
		attr.addAttribute("boardNo", boardDto.getBoardNo());
		return "redirect:detail";
	}
	
	// 게시글 수정
	@GetMapping("/delete")
	public String delete(@RequestParam int boardNo) {
		boardDao.delete(boardNo);
		return "redirect:list";
	}
	
}
