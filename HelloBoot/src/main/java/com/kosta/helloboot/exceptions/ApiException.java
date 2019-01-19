package com.kosta.helloboot.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ApiException extends RuntimeException{
	private List<FieldError> fieldErros;

	public ApiException(List<FieldError> fieldErros) {
		this.fieldErros = fieldErros;
	}

	public List<FieldError> getFieldErros() {
		return fieldErros;
	}

	public void setFieldErros(List<FieldError> fieldErros) {
		this.fieldErros = fieldErros;
	}
}
