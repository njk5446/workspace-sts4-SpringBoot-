package com.rubypaper.persistence;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

//JPARepository는 CRUDRepository의 확장판이니까 JPARepository 사용하면됨
public interface BoardRepository extends JpaRepository<Board, Long>{ 
	// JpaRepository<엔티티 클래스 타입, 식별자 타입(@Id로 매핑한 식별자 변수 타입)>
	// JpaRepository는 내장 객체로서, 다양한 내장 메서드를 사용하는데 쓰인다.
	// class-interface 관계는 implements
	// interface-interface 관계는 extends
	
	// 쿼리 메소드: 메서드명으로 간단한 쿼리문 조건들을 자동으로 만들어준다
	// find + 엔티티 이름 + By + 변수 이름 
	// Ex) findBoardByTitle(String search): SELECT b FROM Board b WHERE b.title = 'search' 
	
	List<Board> findByTitle(String searchKeyword); // SELECT b FROM Board b WHERE b.title = searchKeyword;
	
	List<Board> findByContentContaining(String search); // SELECT b FROM Board b WHERE b.title LIKE "%search%" 
	
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	// SELECT b FROM Board b WHERE b.title LIKE "%title%" OR b.content LIKE "%content%"
	
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	// SELECT b FROM Board b WHERE b.title LIKE "%title%" ORDER BY b.seq DESC;
	
	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	//Pageable paging = PageRequest.of(0, 5); // 0번째 page부터 5번째 page까지..
	
//	@Query("SELECT b FROM Board b WHERE b.title LIKE %?1 ORDER BY b.seq DESC")
//	List<Board> queryAnnotationTest1(String searchKeyword);
	
//	@Query("SELECT b.seq, b.title, b.writer, b.createDate "
//			+ "FROM Board b "
//			+ "WHERE b.title LIKE %?1 "
//			+ "ORDER BY b.seq DESC")
//	List<Object[]> queryAnnotationTest2(String searchKeyword);
	
}
