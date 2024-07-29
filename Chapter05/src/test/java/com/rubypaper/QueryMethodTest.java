package com.rubypaper;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryMethodTest {
	
	@Autowired
	private BoardRepository boardRepo;
	
//	@Test
//	public void testFindByTitle() {
//		
//		List<Board> list = boardRepo.findByTitle("title10");
//		System.out.println("--> testFindByTitle");
//		for (Board b : list) {
//			System.out.println(b);
//		}
//	}
//	
//	@Test
//	public void testByContentContaining() {
//		List<Board> boardList = boardRepo.findByContentContaining("5");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//	}
	
//	@Test
//	public void testByTitleContainingOrContentContaining() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("5", "7");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//		System.out.println("---> " + board.toString());
//		}
//	}
	
//	@Test
//	public void testByTitleContainingOrderBySeqDesc() {
//		List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//		System.out.println("---> " + board.toString());
//		}
//	}
	
//	@Test
//	public void testFindBYTitleContaining() {
//		Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "content");
//		List<Board> boardList = boardRepo.findByTitleContaining("title", paging);
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//		System.out.println("---> " + board.toString());
//		}
//	}
	


}
