package com.rubypaper.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestController {
	
	private final BoardRepository boardRepo; // 게시판 
	
	@GetMapping("/board")
	public List<Board> getAllBoards() {
		return boardRepo.findAll(); //findAll: 리스트를 만들면서 모든 객체들을 가져와 리스트에 넣는다
	}
	
	@GetMapping("/board/{seq}") //파라미터 입력한 시퀀스만 가져온다
	public Board searchBoard (@PathVariable Long seq) {
		return boardRepo.findById(seq).get(); 
		// findById: 해당 파라미터 시퀀스에 해당하는 객체만 가져온다 
	}
	
	@PostMapping("/board")
	public Board insertBoard(Board board) {// 메서드와 파라미터의 타입을 맞춰준다
		//왜냐, POST의 board 바디에서 입력한 값들을 넣어주기 위해서
		Board board1 = new Board(); // Board에 추가하기 위한 새로운 객체(글) 생성
		board1.setTitle(board.getTitle()); //POST에서 입력한 board의 title를 가져와서 저장
//		board1.setWriter(board.getWriter()); //POST에서 입력한 board의 writer를 가져와서 저장
		board1.setContent(board.getContent()); //POST에서 입력한 board의 content를 가져와서 저장
		board1.setCreateDate(new Date()); //Date는 현재의 날짜를 생성
		board1.setCnt(0L); // 조회수 Count는 Default로 0값
		
		return boardRepo.save(board1); //boardRepository 저장소에 입력한 board1을 추가(저장)
	}
	
	@PutMapping("/board")
	public Board reviseBoard(Board board) {
		Board b = boardRepo.findById(board.getSeq()).get();
		//findById: 수정할 board의 seq를 찾는다
		if (b == null) // 수정할 board가 비어있으면
			return null; // nullPointerException 발생
		b.setTitle(board.getTitle()); // 수정
		b.setContent(board.getContent()); // 수정
		b.setCreateDate(new Date()); // 수정날짜로 수정
		return boardRepo.save(b); //수정한 board를 저장소에 다시 붙인다
	}
	
	@DeleteMapping("/board/{seq}") //
	public Board deleteBoard(@PathVariable Long seq) { //파라미터(url)에 수정하려는 board의 seq를 입력
		//@PathVariable: url에서 ?변수명을 적지않고 값만 적어도 됨
		Board deleteBoard = boardRepo.findById(seq).get(); //먼저 수정할 Board의 seq를 찾고, get()을 통해 해당 타입으로 캐스팅한다.
		// get(): Optional 내장객체의 메서드로, 변수로 선언한 타입으로 자동 캐스팅해준다.. 
		if (deleteBoard == null) // 해당 board가 비어있으면 nullPointerException 발생
			return null;
		boardRepo.deleteById(deleteBoard.getSeq()); 
		// 먼저 게시판안의 삭제하고싶은 deleteBoard의 seq를 찾는다
		// boardRepo는 게시판이고, boardRepo.deleteById(삭제할 게시글.getSeq())
		return deleteBoard; //삭제된 게시글을 화면에 출력
		
	}
}
