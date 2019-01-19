package com.kosta.helloboot.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosta.helloboot.response.ApiResponse;
import com.kosta.helloboot.response.error.ApiError;
import com.kosta.helloboot.response.error.ApiErrors;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ApiResponse getApiErrorHandler(RuntimeException e) {
		
		if(e instanceof ApiException) {
			ApiException apiException = (ApiException)e;
			
			List<FieldError> fieldErrors = apiException.getFieldErros();
			
			List<ApiError> errorMessages = fieldErrors
					.stream()
					.map(error -> {
						// Not Empty / Length / Range / RegExp
						String validationType = error.getCode();
						if(validationType.equals("NotEmpty")) {
							ApiError apiError = ApiErrors.MISSING_REQUIRE_FIELD;
							String message = apiError.getMessage();
							String filed = error.getField();
//							message = String.format(message, filed);
							message = filed + ":" + message;
//							apiError.setMessage(message);
							return new ApiError(apiError.getCode(), message);
						} else {
							ApiError apiError = ApiErrors.VALIDATION_FAIL;
							String message = apiError.getMessage();
							String filed = error.getField();
							String defaultMessage = error.getDefaultMessage();
							message = filed + ":" + message;
							// "%s prevent %s policy"
//							message = String.format(message
//													, filed
//													, validationType + "(" + defaultMessage + ")");
//							apiError.setMessage(message);
							return new ApiError(apiError.getCode(), message);
						}
					})
					.collect(Collectors.toList());
			
			return new ApiResponse(errorMessages);
		} else if (e instanceof DataAccessException) {
			return new ApiResponse(ApiErrors.NO_DATA);
		} else if (e instanceof org.springframework.web.method.annotation.MethodArgumentTypeMismatchException) {
			return new ApiResponse(ApiErrors.INVALID_PARAMETER);
		}
		return new ApiResponse(ApiErrors.INTERNAL_SERVER_ERROR);
	}
}
