package com.campus.myapp.controller;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Clova_Speech_recognition {

	@GetMapping("/speech")
	public String speechForm() {
		return "clova_speech_recognition";
	}
	
	@PostMapping("/speechRecOk")
	@ResponseBody
	public String speechRecognitionOk(MultipartFile mp3file, String language, HttpSession session) {
		String clientId = "b1evdsku7x";             // Application Client ID";
        String clientSecret = "ypwLWammk3JqK9svCZjK1KzCMBU6VO1jOb3xY26e";     // Application Client Secret";

        // 업로드할 경로
        String path = session.getServletContext().getRealPath("/file");
        // 업로드 실행 ----------
        String filename = ClovaFileUpload.fileUpload(path, mp3file);
        StringBuffer response = new StringBuffer();
        
        try {
        	
        	String imgFile = path+"/"+filename; // 음성 파일 경로
            File voiceFile = new File(imgFile);

            // String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		
		return response.toString();
	}
}
