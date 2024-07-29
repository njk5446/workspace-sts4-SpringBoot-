package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component // Component: 서버 구동시 자동 실행되게하는 어노테이션
public class DataInit2 implements ApplicationRunner{ // 서버 구동시 자동 실행 인터페이스
	// 실행될때만 살아있는 메모리
	private final BoardRepository boardRepo;
	private final MemberRepository memberRepo; // Member의 각 인스턴스를 저장하는 Repository
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Member m1 = Member.builder() //builder(): m1 인스턴스의 필드에 값을 넣는다
				.id("member1")
				.password("member111")
				.name("둘리")
				.role("User").build(); // builder로 필드 데이터를 넣었으면 build로 닫아준다.
		memberRepo.save(m1); // m1 인스턴스 객체를 MemberRepository에 저장
		
		Member m2 = Member.builder()
				.id("member2")
				.password("member222")
				.name("도우너")
				.role("Admin").build();
		memberRepo.save(m2);
				
		for (int i = 1; i <= 5; i++) {
			boardRepo.save(Board.builder()
					.title("title" + i)
					.member(m1) //아까 
					.content("content" + i)
					.createDate(new Date())
					.cnt((long)(Math.random()*5))
					.build()
					);
		}
			for (int i = 1; i <= 5; i++) {
				boardRepo.save(Board.builder()
						.title("title" + i)
						.member(m2)
						.content("content" + i)
						.createDate(new Date())
						.cnt((long)(Math.random()*5))
						.build()
						);
		}
			
			
		Member member = memberRepo.findById("member1").get();
		
		System.out.println("======================");
		System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
		System.out.println("======================");
		List<Board> list = member.getBoardList();
		for(Board board : list) {
			System.out.println(board.toString());
		}
		
		memberRepo.deleteById("member2");
		
	}
}
