package com.rubypaper.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired // DB의 비즈니스 로직을 처리하기 위해서 Service 빈의 의존성을 Repository에 주입 (연결하는 느낌)
	private BoardRepository boardRepo;
	
	public List<Board> getBoardList(Board board) {
		return (List<Board>) boardRepo.findAll(); // boardRepo에 저장된 리스트를 전부 반환 
	}
	
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}
	
	public Board getBoard(Board board) {
		return boardRepo.findById(board.getSeq()).get();
	}
	
	public void updateBoard(Board board) {
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepo.save(findBoard);
	}
	
	public void deleteBoard(Board board) {
		boardRepo.deleteById(board.getSeq());
	}
	
	
	
}
