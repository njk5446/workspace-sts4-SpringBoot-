package com.rubypaper.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.rubypaper.domain.Board;

//동적쿼리를 사용하기 위해선 QuerydslPredicateExecutor 인터페이스를 추가로 상속해야한다
//동적쿼리란?
//
public interface DynamicBoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

}
