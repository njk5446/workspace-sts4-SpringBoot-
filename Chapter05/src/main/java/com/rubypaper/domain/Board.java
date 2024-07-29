package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity //Entity가 설정된 클래스를 엔티티라 하며, 기본적으로 클래스 이름과 동일한 테이블과 매핑된다.
@Builder
@AllArgsConstructor //해당 어노테이션을 선언한 클래스의 모든 필드를 파라미터로 받는 생성자를 자동으로 생성한다
@NoArgsConstructor //해당 어노테이션을 선언한 클래스의 파라미터가 없는 기본 생성자를 자동으로 생성한다
//파라미터가 있는 생성자를 만들면 기본생성자는 자동으로 생성되지않기때문에 @NoArgsConstructor 어노테이션을 통해 자동 생성시키면된다.
public class Board {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq; 
	//GeneratedValue: JPA에서 엔티티로 선언한 클래스의 기본키를 자동으로 생성하는 어노테이션
	//Auto-Increment와 같다고 보면됨..
	//뒤에는 그냥 공식처럼 외워라
	private String title;
//	private String writer;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	//Temporal: JPA에서 날짜와 시간 데이터를, 
	//Date, Calendar 타입의 필드를 DB에서 적절한 날짜/시간 타입으로 변환해준다.
	//뒤에는 그냥 공식처럼 외워라
	private Date createDate;
	private Long cnt;
	
	@ManyToOne //다대일 Board(Many)나 자신 : Member(One) 선언한 필드명
	@JoinColumn(name="MEMBER_ID") //Member 테이블의 id 필드와 연결될 필드명
	// JoinColumn을 하지 않아도 Member 클래스의 Column을 선언한 필드를 연결한다..
	private Member member;
	
	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}

	@Override
	public String toString() {
		return "Board [번호=" + seq + ", 제목=" + title + ", 내용=" + content + ", 등록일자=" + createDate
				+ ", 조회수=" + cnt + ", 사용자=" + member + "]";
	}

	
	
	
}
