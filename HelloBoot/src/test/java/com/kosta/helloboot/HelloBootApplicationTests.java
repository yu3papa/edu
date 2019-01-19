package com.kosta.helloboot;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Type;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kosta.helloboot.board.vo.Board;
import com.kosta.helloboot.response.ApiDataResponse;
import com.kosta.helloboot.response.ApiResponse;
import com.kosta.helloboot.response.error.ApiError;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloBootApplicationTests {

	@Value("${local.server.port}")
	private int port;

	private String host;

	private RestTemplate rest;
	private HttpHeaders headers;

	private Gson gson;

	@Before
	public void setup() {
		host = "http://localhost:" + port;
		rest = new RestTemplate();
		gson = new Gson();
		headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
	}

	@Test
	public void createPost_Failed_NotEmpty_Both() {

		Board board = new Board();
		String requestJson = gson.toJson(board);
//			{
//				"subject" : null,
//				"content" : null
//			}

		HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

		ResponseEntity<String> response = rest.exchange(host + "/posts", HttpMethod.POST, entity, String.class);

		String responseBody = response.getBody();
		System.out.println("responseBody:" + responseBody);

		ApiResponse apiResponse = gson.fromJson(responseBody, ApiResponse.class);

		assertTrue(apiResponse.getStatus().equals("Failed"));
		assertTrue(apiResponse.getError().size() == 2);
		
		for (ApiError apiError : apiResponse.getError()) {
			assertTrue(apiError.getCode().equals("1000"));
			
		}
	}
	
	

	@Test
	public void createPost_Failed_Length_Subject() {

		Board board = new Board();
		board.setSubject("abc");
		board.setContent("content");
		String requestJson = gson.toJson(board);
//			{
//				"subject" : "abc",
//				"content" : "content"
//			}

		HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

		ResponseEntity<String> response = rest.exchange(host + "/posts", HttpMethod.POST, entity, String.class);

		String responseBody = response.getBody();
		System.out.println("responseBody:" + responseBody);

		ApiResponse apiResponse = gson.fromJson(responseBody, ApiResponse.class);

		assertTrue(apiResponse.getStatus().equals("Failed"));
		assertTrue(apiResponse.getError().size() == 1);
		
		for (ApiError apiError : apiResponse.getError()) {
			assertTrue(apiError.getCode().equals("1001"));
			System.out.println("==>"+apiError.getMessage());
			assertTrue(apiError.getMessage().equals("subject:%s prevent %s policy"));
			
		}
	}
	

	@Test
	public void createPost_OK() {

		Board board = new Board();
		board.setSubject("Subject Test Code");
		board.setContent("content");
		String requestJson = gson.toJson(board);
//			{
//				"subject" : "Subject Test Code",
//				"content" : "content"
//			}

		HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
		
		// GET 요청시의 Http Request Message HttpEntity<String> entity = new HttpEntity<>(headers);

		ResponseEntity<String> response = rest.exchange(host + "/posts", HttpMethod.POST, entity, String.class);

		String responseBody = response.getBody();
		System.out.println("responseBody:" + responseBody);
		
		// Generic 변환을 위한 Type 생성
		Type boardType = new TypeToken<ApiDataResponse<Board>>() {}.getType();
		
		ApiDataResponse<Board> apiResponse = gson.fromJson(responseBody, boardType);

		assertTrue(apiResponse.getStatus().equals("OK"));
		assertTrue(apiResponse.getError().size() == 0);
		
		Board responseBoard = apiResponse.getData();
		
		System.out.println("responseBoard:" + responseBoard);
		assertTrue(responseBoard == null);
//		assertTrue(responseBoard.getSubject().equals(board.getSubject()));
//		assertTrue(responseBoard.getContent().equals(board.getContent()));

	}
}
