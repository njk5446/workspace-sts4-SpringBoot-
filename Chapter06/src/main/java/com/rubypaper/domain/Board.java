package com.rubypaper.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// Board 클래스 생성
// Entity 어노테이션을 Board 클래스에 지정해서 Board 클래스의 정보들을 JPA를 통해 CRUD 사용
// JPA란? CRUD(Create Remove, Update, Delete) 작업을 SQL을 직접 작성하지 않고도 DB와 상호작용 (객체 지향적으로 처리)
@Getter
@Setter
@ToString
@Entity //Entity가 설정된 클래스를 엔티티라 하며, 기본적으로 클래스 이름과 동일한 테이블과 매핑된다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	@Id // 기본키 지정 어노테이션
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	// 해당 어노테이션을 추가해서 DB종류(Oracle, mySQL, H2등등)에 맞는 키 생성 전략이 적용된다
	// GenerationType.AUTO : Oracle, mySQL, H2 중 DB를 자동 판별해서 Auto-Increment로 기본키를 생성
	// GenerationType.IDENTITY: mySQL, H2의 Auto-Increment로 기본키를 생성
	// GenerationType.SEQUENCE: Oracle에서 Auto-Increment로 기본키를 생성
	private Long seq;
	
	
	private String title;
	
	@Column(updatable=false)
	private String writer;
	
	private String content;
	
//	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable=false, updatable=false, columnDefinition="date default current_date()")
	private Date createDate;
	
	@Column(insertable=false, columnDefinition="number default 0") //조회수 default 0
	private Long cnt;

}
