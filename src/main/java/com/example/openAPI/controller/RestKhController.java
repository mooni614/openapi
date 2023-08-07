package com.example.openAPI.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RestKhController {

	// 인증키: RIqgdTVVcXYrj3Tu11ujiaCJdR%2FnJN0zmwoeAdZMRQROvCASHlIO6XMcaILELMsUFiWVLvCEWLmaaafJ226PpA%3D%3D
	// 요청 url : http://apis.data.go.kr/6480000/gyeongnamgallery/gyeongnamgalleryList
	
	
	@GetMapping("/khapi")
	public String khapi() {
		
		StringBuffer result = new StringBuffer();
		
		int pageNo = 1;

		try {
		String apiUrl = "http://apis.data.go.kr/6480000/gyeongnamgallery/gyeongnamgalleryList?" + 
				"serviceKey=RIqgdTVVcXYrj3Tu11ujiaCJdR%2FnJN0zmwoeAdZMRQROvCASHlIO6XMcaILELMsUFiWVLvCEWLmaaafJ226PpA%3D%3D"+
				"&numOfRows=10"+"&pageNo="+pageNo +"&resultType=xml";
		
		URL url = new URL(apiUrl);
		
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); 
		
		urlConnection.setRequestMethod("GET");
		

		BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream,"UTF-8"));
		String returnLine;
		
		
		result.append("<xmp>");
		
		while((returnLine = bufferedReader.readLine()) !=null) {
			result.append(returnLine+"\n");
			
			
		}
		
		urlConnection.disconnect();
		
		
	} catch (Exception e) { // 모든 예외에 대해 처리하겠다.
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return result + "</xmp>";
	
		
		
	}
	
	
	@GetMapping("/khjson")
	public String khjson() {
		

		StringBuffer result = new StringBuffer();
		String jsonPrintString = null;

		

		try {
		String apiUrl = "http://apis.data.go.kr/6480000/gyeongnamgallery/gyeongnamgalleryList?" + 
				"serviceKey=RIqgdTVVcXYrj3Tu11ujiaCJdR%2FnJN0zmwoeAdZMRQROvCASHlIO6XMcaILELMsUFiWVLvCEWLmaaafJ226PpA%3D%3D"+
				"&numOfRows=10"+"&pageNo=1";
		
		URL url = new URL(apiUrl);
		
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); 
		
		url.getContent();
		

		BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream,"UTF-8"));
		String returnLine;
		
		
		
		while((returnLine = bufferedReader.readLine()) !=null) {
			result.append(returnLine+"\n");
			
			
		}
		
		
		JSONObject jsonObject = XML.toJSONObject(result.toString());
		jsonPrintString = jsonObject.toString();
		
		
		
	} catch (Exception e) { // 모든 예외에 대해 처리하겠다.
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return jsonPrintString;
	
		
		
	}
	
}
