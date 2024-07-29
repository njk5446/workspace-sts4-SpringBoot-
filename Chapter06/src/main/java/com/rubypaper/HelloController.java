package com.rubypaper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프.^^");
	}
	
//	@GetMapping("/hello")
//	public String hello() {
//		// /WEB-INF/board/abcd.jsp
//		return "hello";
//
//	}
	
//	@GetMapping("/hello")
//	public ModelAndView hello(String name) {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name", name);
//		mv.setViewName("hello");
//		return mv;
//	}
//	
	//localhost:8080/hello?name=홍길동
	// Hello~ 홍길동
//	@GetMapping("/hello")
//	public String hello(String name, Model model) { 
//		// name: url에서 입력할 값 ?name=입력값
//		// Model: Controller Bean에서 생성한 데이터를 뷰로 전달하는 역할
//		// /WEB-INF/board/abcd.jsp
//		model.addAttribute("name", name); // addAttribute("${반환할 jsp의 변수명}", jsp에 대입할 변수명) 
//		return "hello"; // hello.jsp를 http로 반환
//	}
	
//	@GetMapping("/hello")
//	public void hello() {
//		// /WEB-INF/board/hello.jsp가 호출된다..
//	}
//	
}
