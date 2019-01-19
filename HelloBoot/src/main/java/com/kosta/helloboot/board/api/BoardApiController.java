package com.kosta.helloboot.board.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.helloboot.board.service.BoardService;
import com.kosta.helloboot.board.vo.Board;
import com.kosta.helloboot.exceptions.ApiException;
import com.kosta.helloboot.response.ApiDataResponse;
import com.kosta.helloboot.response.ApiResponse;
import com.kosta.helloboot.response.error.ApiError;
import com.kosta.helloboot.response.error.ApiErrors;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/posts")
	public ApiResponse getAllBoardsApi() {
		List<Board> boardList = boardService.findAllBoards();

		ApiDataResponse<List<Board>> result = new ApiDataResponse<>(boardList);

		return result;

//		Map<String, Object> result = new HashMap<>();
//		result.put("status", "OK");
//		result.put("data", boardList);
//		result.put("error", "");
//		return result;
	}

	@GetMapping("/posts/{postId}")
	public ApiResponse getOneBoardApi(@PathVariable long postId) {
		Board board = boardService.findOneBoard(postId);
		if (board == null) {
			// return new ApiResponse("Data is empty");
			return new ApiResponse(ApiErrors.NO_DATA);
		}

		ApiDataResponse<Board> result = new ApiDataResponse<>(board);
		return result;

//		Map<String, Object> result = new HashMap<>();
//		result.put("status", "OK");
//		result.put("data", board);
//		result.put("error", "");
//		return result;
	}

	@PostMapping("/posts")
	public ApiResponse createOneBoardApi(@Valid @RequestBody Board board, Errors errors) {

		if (errors.hasErrors()) {
//			List<String> errorMessages= errors.getFieldErrors()
//									.stream()
//									.map(error -> error.getDefaultMessage())
//									.collect(Collectors.toList());
			
			throw new ApiException(errors.getFieldErrors());
		}

		Board newBoard = boardService.createNewBoard(board);

		ApiDataResponse<Board> result = new ApiDataResponse<>(newBoard);
		return result;

//		Map<String, Object> result = new HashMap<>();
//		result.put("status", "OK");
//		result.put("data", newBoard);
//		result.put("error", "");
//		return result;

	}

	@PutMapping("/posts/{postId}")
	public ApiResponse updateOneBoardApi(@PathVariable long postId, @RequestBody Board board) {
		Board origiBboard = boardService.findOneBoard(postId);
		if (origiBboard == null) {
			return new ApiResponse(ApiErrors.NO_DATA);
		}

		board.setPostId(postId);
		Board updatedBoard = boardService.updateOneBoard(board);

		ApiDataResponse<Board> result = new ApiDataResponse<>(updatedBoard);
		return result;

//		Map<String, Object> result = new HashMap<>();
//		result.put("status", "OK");
//		result.put("data", updatedBoard);
//		result.put("error", "");
//		return result;
	}

	@DeleteMapping("/posts/{postId}")
	public ApiResponse deleteOneBoardApi(@PathVariable long postId) {
		boardService.deleteOneBoard(postId);

		return new ApiResponse();
//		Map<String, Object> result = new HashMap<>();
//		result.put("status", "OK");
//		result.put("error", "");
//		return result;
	}
}
