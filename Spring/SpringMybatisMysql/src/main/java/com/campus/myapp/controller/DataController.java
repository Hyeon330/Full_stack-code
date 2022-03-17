package com.campus.myapp.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.campus.myapp.service.DataService;
import com.campus.myapp.vo.DataVO;

@RestController
@RequestMapping("/data/")
public class DataController {
	@Autowired
	DataService service;
	
	ModelAndView mav;
	
	@GetMapping("dataList")
	public ModelAndView dataList() {
		mav = new ModelAndView();
		mav.addObject("list", service.dataSelectAll());
		mav.setViewName("data/dataList");
		
		return mav;
	}
	
	// 자료실 글쓰기 폼
	@GetMapping("write")
	public ModelAndView dataWrite() {
		mav = new ModelAndView();
		mav.setViewName("data/dataWrite");
		return mav;
	}
	
	// 파일 업로드
	@PostMapping("writeOk")
	public ResponseEntity<String> dataWriteOk(DataVO vo, HttpServletRequest request) {
		// vo : subject, content는 request가 됨.
		vo.setUserid((String)request.getSession().getAttribute("logId")); // 글쓴이
		System.out.println(vo.getUserid());
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=utf-8");
//		headers.setContentType(new MediaType("text", "html", Charset.forName("UTF-8")));
		
		String path = request.getSession().getServletContext().getRealPath("/upload"); // 파일업로드를 위한 업로드위치의 절대주소
		System.out.println("path: "+path);
		  
		try {
			// 파일업로드를 처리하기 위해서는 request객체에서 multipart객체로 형변환해야 한다.
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
			
			// mr에 파일의 수만큼 MultipartFile객체가 존재
			List<MultipartFile> files = mr.getFiles("filename"); // mr: MultipartRequest
			System.out.println("업로드 파일수"+files.size());
			
			if(files!=null) {
				int cnt = 1; // 업로드 순서에 따라 filename1, filename2파일명을 대입하기 위한 변수
				
				// 첨부 파일 수 만큼 반복하여 업로드한다.(files.size())
				for (MultipartFile file : files) { // 1. MultipartFile객체를 얻어오기
					// 2. 업로드한 실제 파일명을 구하기
					String orgFileName = file.getOriginalFilename();
					System.out.println("orgFileName :"+orgFileName);
					
					// 3. rename하기
					if(orgFileName!=null && !orgFileName.equals("")) {
						//확장자와 파일을 분리한다
						int point = orgFileName.lastIndexOf(".");
						String fileName = orgFileName.substring(0, point);
						String ext = orgFileName.substring(point+1);
						
						File f = null;
						int renameNum = 0;
						do {
							f = new File(path, fileName+"_"+renameNum+"."+ext);
							renameNum++;
							// 파일이 존재하는지 확인(존재할 때: true, 없을 때: false)
						} while (f.exists());
						orgFileName = f.getName();
						  
						// 4. 파일업로드
						try {
							file.transferTo(f); // 실제 업소르가 발생한다.
						}catch(Exception ee){}
						
						// 5. 업로드한(새로운파일명) vo에 세팅
						if(cnt==1) vo.setFilename1(orgFileName);
						if(cnt==2) vo.setFilename2(orgFileName);
						cnt++;
					}	  
				}				  
			}
			System.out.println(vo.toString());
			  
			// DB등록
			service.dataInsert(vo);
			// 레코드 추가 성공
			String msg = "<script>alert('자료실글등록되었습니다.');location.href='/myapp/data/dataList';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			  
		}catch(Exception e){
			e.printStackTrace();
			// 레코드추가 실패
			// 파일 지우기
			fileDelete(path, vo.getFilename1());
			fileDelete(path, vo.getFilename2());
			// 메세지
			String msg = "<script>alert('자료실글등록실패');history.back();</script>";
			// 이전페이지로 보내기
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 글 내용 보기
	@GetMapping("view")
	public ModelAndView view(int no) {
		mav = new ModelAndView();
		mav.addObject("dataVO", service.dataView(no));
		mav.setViewName("data/dataView");
		return mav;
	}
	
	// 글 수정 페이지
	@GetMapping("dataEdit")
	public ModelAndView Edit(int no) {
		mav = new ModelAndView();
		DataVO vo = service.dataView(no);
		int fileCount = 1; // 첫 번째 첨부파일 무조건 있음
		if(vo.getFilename2() != null){ // 두 번쨰 첨부파일 있으면 1증가
			fileCount++;
		}
		
		mav.addObject("fileCount", fileCount);
		mav.addObject("vo", vo);
		mav.setViewName("data/dataEdit");
		return mav;
	}
	
	// 글 수정DB
	@PostMapping("editOk")
	public ResponseEntity<String> editOk(DataVO vo, HttpSession session) {
		vo.setUserid((String) session.getAttribute("logId"));
		String path = session.getServletContext().getRealPath("/upload");
		System.out.println(vo.toString());
		if(vo.getDelFile()!=null) {
			for (String s : vo.getDelFile()) {
				System.out.println(s);
			}
		}
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=utf-8");
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return entity;
	}
	
	// 파일지우기
	public void fileDelete(String p, String f) {
		if(f != null) { // 파일명이 존재하면
			File file = new File(p, f);
			file.delete();
		}
	}
	
}
