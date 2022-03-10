package com.campus.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MappingController {
	//-- Get방식 접속을 했을때
	// 웹브라우저 url, a태그, location.href, response.sendRedirect, meta, jstl-redirect태그
	
	// url -> http://location:9090/myapp/t1
	// a태그 -> href="/myapp/t1"
	
	@RequestMapping("/t1")// 반환형이 String이면 뷰파일명을 반환한다.
	public ModelAndView test1(HttpServletRequest req) {
		int num = Integer.parseInt(req.getParameter("num"));
		String name = req.getParameter("name");
		
		System.out.println(num + ", " +name);
		
		// 모델과 view를 가진 클래스
		ModelAndView mav = new ModelAndView();
		// 클라이언트 (뷰페잊)로 서버에서 데이터 보내기
		mav.addObject("num", num+100);
		mav.addObject("name", name+" 님");
		mav.setViewName("main/result");
		
		return mav; // WEB-INF/views/main/result.jsp
	}
	
	@RequestMapping("/t2")
//					url의 파라미터와 동일한 변수명을 매개변수로 적어준다
	public String test2(int num, String name, Model model) {
		System.out.println(num+"==="+name);
		model.addAttribute("num", num*10);
		model.addAttribute("name", name+" nim");
		
		return "main/result";
	}
	
	@GetMapping("/t3")
	public ModelAndView test3(DataVO vo) {
		System.out.println(vo.getNum()+"------------"+ vo.getName());
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("main/result");
		
		return mav;
	}
	
	@GetMapping("/t4")
	public String test4(@RequestParam("num") int num, @RequestParam("name") String name, Model model) {
		System.out.println(num+"<-------->"+name);
		model.addAttribute("num", num);
		model.addAttribute("name", name);
		return "main/result";
	}
	
	// GET 방식
//	@RequestMapping(value="/form1", method=RequestMethod.GET)
	@RequestMapping("/form1")
	public ModelAndView form1(DataVO vo) {
		System.out.println("번호 => " + vo.getNum());
		System.out.println("이름 => " + vo.getName());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("main/result");
		
		return mav;
	}
	
	// POST 방식
//	@RequestMapping(value="/form2", method=RequestMethod.POST)
	@PostMapping("/form2")
	public ModelAndView form2(DataVO vo) {
		System.out.println("번호 => " + vo.getNum());
		System.out.println("이름 => " + vo.getName());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("main/result");
		
		return mav;
	}
}
