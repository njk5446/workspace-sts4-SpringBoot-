package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller 
// 웹 어플리케이션(HTTP)의 요청을 처리하고 응답을 생성하는 역할
// 단순히 Controller 어노테이션을 클래스에 붙이면 여러가지 Mapping 어노테이션을 통해서 요청을 처리하고 응답한다고 보면됨
// 근데 이러한 요청을 받아서 처리하기 위해선 @Service가 붙은 클래스에서 처리해야함
public class BoardController {
	
	@Autowired 
	// 요청을 처리하고, 서비스 계층을 호출한다. 이를 호출하기 위해선,
	// Autowired를 통해서 BoardService 클래스를 Controller에 의존성 주입
	// Spring이 자동으로 Autowired된 Bean 객체를 주입할 수 있게 해줌
	private BoardService boardService;
	

	
	@RequestMapping(value ="/getBoardList", method = { RequestMethod.GET, RequestMethod.POST})
	public String getBoardList(Model model, Board board) { // Model 내장 객체를 
		List<Board> boardList = boardService.getBoardList(board); 
		// boardService의 getBoardList의 findAll로 리스트인 boardList에 전부 집어넣는다 
		// 그러면 boardList에는 Board의 각 인스턴스들이 들어가있음
		model.addAttribute("boardList", boardList); // addAttribute("${반환할 jsp의 변수명}", jsp에 대입할 변수명)
		return "getBoardList"; // getBoardList.jsp를 http로 반환
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	@GetMapping("/insertBoard")
	public void insertBoardView() {
		
	}
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
//	@GetMapping("/getBoardList")
//	public String getBoardList(Model model) {
//		List<Board> boardList = new ArrayList<>();
//		
//		for (int i = 1; i <= 10; i++) {
//			Board board = new Board();
//			board.setSeq((long) i);
//			board.setTitle("게시판 프로그램 테스트"); 
//			board.setWriter("도우너"); 
//			board.setContent("게시판 프로그램 테스트입니다..."); 
//			board.setCreateDate(new Date()); 
//			board.setCnt(0L); 
//			boardList.add(board);
//		}
//		model.addAttribute("boardList", boardList);
//		return "getBoardList";
//	}
	
}
