package com.campus.myapp.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Clova_summary {
	
	@GetMapping("/summaryform")
	public String summary() {
		return "clova_summary";
	}
	
	@PostMapping("/summaryOk")
	@ResponseBody
	public String summaryOk(String title, String content) {
		String clientId = "b1evdsku7x";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "8JtwWdDuyYcyxezEO5RsuZgENMAfitaPHszriL03";//애플리케이션 클라이언트 시크릿값";
        
        StringBuffer response = new StringBuffer();
        String summary = "";
        
        try {
        	// 전송할 데이터를 제이슨 형식으로 만들기
        	JSONObject jsonDoc = new JSONObject();
        	jsonDoc.put("title", title);
        	jsonDoc.put("content", content);
        	
        	JSONObject jsonOpt = new JSONObject();
        	jsonOpt.put("language", "ko");
        	jsonOpt.put("model", "news");
        	jsonOpt.put("tone", "2");
        	jsonOpt.put("summaryCount", 3);
        	
        	JSONObject jsonData = new JSONObject();
        	jsonData.put("document", jsonDoc);
        	jsonData.put("option", jsonOpt);
        	String jsonContent = jsonData.toString();
        	System.out.println("jsonContent=> "+jsonContent);
        	
            String apiURL = "https://naveropenapi.apigw.ntruss.com/text-summary/v1/summarize";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            // 전송데이터타입
            con.setRequestProperty("Content-Type", "application/json");
            
            // post request
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.write(jsonContent.getBytes());
            wr.flush();
            wr.close();
            
            // 결과
            int responseCode = con.getResponseCode();
            BufferedReader br = null;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println("응답받은 정보 => "+response.toString());
            }
            
            JSONObject resultJson = new JSONObject(response.toString());
            summary= resultJson.get("summary").toString();
        }catch (Exception e) {
        	e.printStackTrace();
        }
        
		return summary;
	}
}
