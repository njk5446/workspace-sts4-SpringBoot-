package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.Board;

// 비즈니스 로직을 처리하는데 사용
public interface BoardService {

	List<Board> getBoardList(Board board);

	void insertBoard(Board board);

	Board getBoard(Board board);

	void updateBoard(Board board);

	void deleteBoard(Board board);

}