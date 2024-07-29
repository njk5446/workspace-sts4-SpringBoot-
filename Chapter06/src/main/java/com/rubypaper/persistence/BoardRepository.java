package com.rubypaper.persistence;

import org.springframework.data.repository.CrudRepository;

import com.rubypaper.domain.Board;

// Repository: DB 접근 클래스에 사용 (데이터와 상호작용하는 클래스에 붙음)
// CrudRepository와 같이 JPA로 사용될 경우 자동으로 빈 등록이 되기 때문에
// @Repository와 같이 빈 객체로 등록하지 않아도된다
public interface BoardRepository extends CrudRepository<Board, Long>{
	
}
