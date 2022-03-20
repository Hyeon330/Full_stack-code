package com.campus.myapp.controller;

import java.io.File;
import java.net.http.HttpRequest;
import java.util.ArrayList;
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
	public ResponseEntity<String> editOk(DataVO vo, HttpSession session, HttpServletRequest request) {
		vo.setUserid((String) session.getAttribute("logId"));
		String path = session.getServletContext().getRealPath("/upload");
		
//		삭제할 파일 확인
//		System.out.println(vo.toString());
//		if(vo.getDelFile()!=null) {
//			for (String s : vo.getDelFile()) {
//				System.out.println(s);
//			}
//		}
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=utf-8");
		
		List<String> fileList = new ArrayList<String>(); // 새로 DB에 업데이트할 파일명
		List<String> newUpload = new ArrayList<String>(); // 새로업로드 한 파일명
		try {
			// 1. DB에서 파일명 가져오기
			DataVO dbFileVO = service.getFileName(vo.getNo());
			fileList.add(dbFileVO.getFilename1());
			if(dbFileVO.getFilename2()!=null) fileList.add(dbFileVO.getFilename2());
			
			// 2. 삭제된 파일이 있을 경우 List에서 같은 파일명을 지운다.
			if(vo.getDelFile() != null) { // null이면 삭제할 파일이 없다.
				for (String delFile : vo.getDelFile()) {
					fileList.remove(delFile);
				}
			}
			
			// 3. 새로 업로드 하기
			MultipartHttpServletRequest mr = (MultipartHttpServletRequest) request;
			
			// 새로 업로드된 MultipartFile객체를 얻어오기
			List<MultipartFile> newFileList = mr.getFiles("filename");
			if(newFileList != null) { // 새로업로드된 파일이 있으면
				for (MultipartFile newFile : newFileList) {
					String newUploadFileName = newFile.getOriginalFilename();
					
					if(newUploadFileName != null && !newUploadFileName.equals("")) {
						int point = newUploadFileName.lastIndexOf(".");
						String fileNameNoExt = newUploadFileName.substring(0,point);
						String ext = newUploadFileName.substring(point+1);
						
						File f = null;
						int n = 0;
						do {
							f = new File(path, fileNameNoExt+"_"+n+"."+ext);
							n++;
						} while (f.exists());
						newUploadFileName = f.getName();
						
						// 업로드
						try {
							newFile.transferTo(f);
						} catch (Exception e) {}
						fileList.add(newUploadFileName); // db에 등록할 파일명에 추가
						newUpload.add(newUploadFileName); // 새로업로드목록에 추가
					}
				}
			}
			
			// fileList에 있는 DB에 등록할 파일명을 vo.filename1, vo.filename2에 세팅
			for(int i=0; i<fileList.size(); i++) {
				if(i==0) vo.setFilename1(fileList.get(i));
				if(i==1) vo.setFilename2(fileList.get(i));
			}
			
			// DB update
			service.dataUpdate(vo);
			
			// DB 수정되었을때
			if(vo.getDelFile() != null) {
				for(String fname : vo.getDelFile()) {
					fileDelete(path, fname);
				}
			}
			
			// 글 내용 보기로 이동
			String msg = "<script>alert('자료실글이 수정되었습니다. \\n 글내용보기로 이동합니다.');";
			msg+="location.href='/myapp/data/view?no="+vo.getNo()+"';</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			// DB수정 못 했을때
			for (String fname : newUpload) {
				fileDelete(path, fname);
			}
			// 수정페이지로 이동
			String msg = "<script>";
			msg += "alert('글수정 실패하였습니다. \\n수정폼으로 이동합니다.');";
			msg += "history.back();</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	// 자료실 삭제
	@GetMapping("dataDel")
	public ResponseEntity<String> dataDel(int no, HttpServletRequest req) {
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("logId");
		String path = session.getServletContext().getRealPath("/upload");
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "Text/html; charset=utf-8");
		
		try {
			// 1. 삭제할 레코드의 파일 명 얻어오기
			DataVO dbFileVO = service.getFileName(no);
			
			// 2. 레코드 삭제
			service.dataDelete(no, userid);
			
			// 3. 파일 삭제
			fileDelete(path, dbFileVO.getFilename1());
			if(dbFileVO.getFilename2() != null) fileDelete(path, dbFileVO.getFilename2());
			
			String msg = "<script>alert('글이 삭제되었습니다.');location.href='"+req.getContextPath()+"/data/dataList';</script>";
			
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			String msg = "<script>alert('글 삭제 실패');history.back();</script>";
			
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
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
