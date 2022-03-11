package com.campus.myapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	@RequestMapping("/ajaxView")
	public String ajaxView() {
		return "ajax/ajaxView";
	}
	
	@RequestMapping(value="/ajaxString", method=RequestMethod.GET, produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajaxString(int num, String name, String addr) {
		System.out.println("num: " + num);
		System.out.println("name: " + name);
		System.out.println("addr: " + addr);
		
		String data = "번호: " + num + "<br>" + "이름: " + name + "<br>" + "주소: " + addr;
		
		return data;
	}
	
	@RequestMapping("/ajaxObject")
	@ResponseBody
	public ProductVO ajaxObject(int num, String name) {
		System.out.println(num+"===>"+name);
		
		// ProductVO에 데이터를 담아서 ajax에게 보내기
		ProductVO vo = new ProductVO(1234, "컴퓨터", 120000, 13);
		
		return vo;
	}
	
	//List
	@RequestMapping("/ajaxList")
	@ResponseBody
	public List<ProductVO> ajaxList() {
		List<ProductVO> list = new ArrayList<ProductVO>();
		list.add(new ProductVO(100, "책상", 12000, 2));
		list.add(new ProductVO(200, "의자", 50000, 4));
		list.add(new ProductVO(300, "모니터", 150000, 2));
		list.add(new ProductVO(400, "노트북", 1189000, 1));
		
		return list;
	}
	
	//Map
	@RequestMapping("/ajaxMap")
	@ResponseBody
	public Map<String, ProductVO> ajaxMap() {
		Map<String, ProductVO> map = new HashMap<String, ProductVO>();
		map.put("p1", new ProductVO(100, "책상", 12000, 2));
		map.put("p2", new ProductVO(200, "의자", 50000, 4));
		map.put("p3", new ProductVO(300, "모니터", 150000, 2));
		map.put("p4", new ProductVO(400, "노트북", 1189000, 1));
		map.put("p5", new ProductVO(500, "데스크탑", 1590000, 1));
		
		return map;
	}
	
	//Json
	@RequestMapping("/ajaxJson")
	@ResponseBody
	public String ajaxJson(int no, String name, String tel) {
		System.out.println(no+">>"+name+">>"+tel);
		int proNo = 1234;
		String proName = "냉장고";
		int price = 1254200;
		
		String txt = "{"
				+ "\"proNo\": " + proNo+", "
				+ "\"proName\": \"" + proName+"\", "
				+ "\"price\": " + price
				+ "}";
		
		System.out.println(txt);
		return txt;
	}
	
	@RequestMapping(value="/ajaxForm", method=RequestMethod.POST)
	public String ajaxForm(ProductVO vo) {
		System.out.println(vo.getProName());
		System.out.println(vo.getPrice());
		
		return "전송완료";
	}
}
