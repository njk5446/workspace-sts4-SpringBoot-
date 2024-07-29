package com.rubypaper;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

@SpringBootTest
public class DataInitializeTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void testDataInsert() {
		Member m1 = Member.builder() //builder(): m1 인스턴스의 필드에 값을 넣는다
				.id("member1")
				.password("member111")
				.name("둘리")
				.role("ROLE_USER").build(); // builder로 필드 데이터를 넣었으면 build로 닫아준다.
		memberRepo.save(m1); // m1 인스턴스 객체를 MemberRepository에 저장
		
		Member m2 = Member.builder()
				.id("member2")
				.password("member222")
				.name("도우너")
				.role("ROLE_ADMIN").build();
		memberRepo.save(m2);
		
		for (int i = 1; i <= 3; i++) {
			boardRepo.save(Board.builder()
					.title("title" + i)
					.content("content" + i)
					.createDate(new Date())
					.cnt((long)(Math.random()*5))
					.build()
					);
		}
			for (int i = 1; i <= 3; i++) {
				boardRepo.save(Board.builder()
						.title("title" + i)
						.content("content" + i)
						.createDate(new Date())
						.cnt((long)(Math.random()*5))
						.build()
						);
		}
	}
}
