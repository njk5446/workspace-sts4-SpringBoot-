package com.rubypaper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;

//	@Test
//	public void testQueryAnnotationTest1() {
//		List<Board> boardList = boardRepo.queryAnnotationTest1("title10");
//		
//		System.out.println("검색 결과");
//		for (Board board : boardList) {
//		System.out.println("---> " + board.toString());
//		}	
//	}
	
//	@Test
//	public void testQueryAnnotationTest2() {
//		List<Object[]> boardList = boardRepo.queryAnnotationTest2("title10");
//		
//		System.out.println("검색 결과");
//		for (Object[] board : boardList) {
//			System.out.println("---> " + Arrays.toString(board));
//		}			
//	}
	
	
}
