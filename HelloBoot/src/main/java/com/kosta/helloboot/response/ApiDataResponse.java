package com.kosta.helloboot.response;

public class ApiDataResponse<T> extends ApiResponse {
	private T data;
	
	public ApiDataResponse(T data) {
		super();
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
