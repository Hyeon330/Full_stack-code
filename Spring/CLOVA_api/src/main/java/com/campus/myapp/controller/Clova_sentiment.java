package com.campus.myapp.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Clova_sentiment {

	@GetMapping("/sentimentform")
	public String sentimentForm() {
		return "clova_sentiment";
	}
	
	@PostMapping("/sentimentOk")
	@ResponseBody
	public String sentimentOk(String content) {
		String clientId = "b1evdsku7x";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "8JtwWdDuyYcyxezEO5RsuZgENMAfitaPHszriL03";//애플리케이션 클라이언트 시크릿값";
        
        StringBuffer response = new StringBuffer();
        String sentiment = "";
        
        try {
        	// 전송할 데이터를 제이슨 형식으로 만들기
        	JSONObject jobj = new JSONObject();
        	jobj.put("content", content);
        	String jsonContent = jobj.toString();
        	System.out.println("jsonContent=> "+jsonContent);
        	System.out.println(jobj);
        	
            String apiURL = "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze";
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
            sentiment = (String)((JSONObject)resultJson.get("document")).get("sentiment");
        }catch (Exception e) {}
        
		return sentiment;
	}
}
