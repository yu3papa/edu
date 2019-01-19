package com.kosta.helloboot.response.error;

public interface ApiErrors {
	ApiError MISSING_REQUIRE_FIELD = new ApiError("1000", "% is manadatory field.");
	ApiError VALIDATION_FAIL = new ApiError("1001", "%s prevent %s policy");
	ApiError NO_DATA = new ApiError("1002", "Data is empty");
	ApiError INVALID_PARAMETER = new ApiError("1003", "Invalid Parameter");
	ApiError INTERNAL_SERVER_ERROR = new ApiError("9000", "Unknown Error");
}