package com.campus.myapp.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Clova_CAPTCHA_image {
	
	String clientId = "frhk7ai5ss";//애플리케이션 클라이언트 아이디값";
    String clientSecret = "app51292nY6if4XsVztMLbG4BvhUFmosCwie6PW9";//애플리케이션 클라이언트 시크릿값";
    String key = ""; // 발급키가 비교시 사용됨
	
	@GetMapping("/captchaform")
	public String captchaForm() {
		return "clova_captcha_image";
	}
	
	// 키를 발급받아 해당 이미지를 클라이언트에게 보내기
	@GetMapping("/captchaImage")
	public void captchaImage(HttpServletResponse res) {
        try {
            String key = getkey(); // https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey 호출로 받은 키값
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha-bin/v1/ncaptcha?key=" + key + "&X-NCP-APIGW-API-KEY-ID" + clientId;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                InputStream is = con.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];
                // 랜덤한 이름으로 파일 생성
                // String tempname = Long.valueOf(new Date().getTime()).toString();
                // File f = new File(tempname + ".jpg");
                // f.createNewFile();
                // OutputStream outputStream = new FileOutputStream(f);
                OutputStream outputStream = res.getOutputStream();
                while ((read =is.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                is.close();
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
	}
	// 사용자가 입력한 값을 체크해주는 컨트롤러
	@PostMapping("/captchaCheck")
	public ModelAndView captchaCheck(String userin) {
		ModelAndView mav = new ModelAndView();
		try {
            String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            // String key = "CAPTCHA_KEY"; // 캡차 키 발급시 받은 키값
            String value = userin; // 사용자가 입력한 캡차 이미지 글자값
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code +"&key="+ key + "&value="+ value;

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            
            JSONObject jObj = new JSONObject(response.toString());
            boolean result = (boolean)jObj.get("result");
            if(result) { // 성공
            	mav.addObject("result", "success");
            	mav.setViewName("clova_captcha_result");
            }else { // 실패
            	mav.setViewName("redirect:/captchaform");
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return mav;
	}
	
	// 키 발급받기
	public String getkey() {
		StringBuffer response = new StringBuffer();
		try {
            String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
            String apiURL = "https://naveropenapi.apigw.ntruss.com/captcha/v1/nkey?code=" + code;
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            
            JSONObject keyObj = new JSONObject(response.toString());
            key = (String)keyObj.get("key");
            
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return key;
	}
}
