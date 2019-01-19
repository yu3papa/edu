package com.kosta.helloboot.member.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.helloboot.exceptions.ApiException;
import com.kosta.helloboot.member.service.MemberService;
import com.kosta.helloboot.member.vo.Member;
import com.kosta.helloboot.response.ApiDataResponse;
import com.kosta.helloboot.response.ApiResponse;
import com.kosta.helloboot.response.error.ApiError;
import com.kosta.helloboot.response.error.ApiErrors;

@RestController
public class MemberApiController {

	@Autowired
	private MemberService memberService;

	@PostMapping("/members")
	public ApiResponse createOneBoardApi(@Valid @RequestBody Member member, Errors errors) {

		if (errors.hasErrors()) {
			throw new ApiException(errors.getFieldErrors());
		}

		Member newMember = memberService.createNewMember(member);

		ApiDataResponse<Member> result = new ApiDataResponse<>(newMember);
		return result;

	}

	@GetMapping("/members/{memberId}")
	public ApiResponse getOneMemberApi(@PathVariable long memberId) {
		Member member = memberService.findOneMember(memberId);
		if (member == null) {
			//return new ApiResponse("Data is empty");
			return new ApiResponse(ApiErrors.NO_DATA);
		}

		ApiDataResponse<Member> result = new ApiDataResponse<>(member);
		return result;
	}

	@GetMapping("/members")
	public ApiResponse getAllMembersApi() {
		List<Member> boardList = memberService.findAllMembers();

		ApiDataResponse<List<Member>> result = new ApiDataResponse<>(boardList);

		return result;
	}

	@DeleteMapping("/members/{memberId}")
	public ApiResponse deleteOneMemberApi(@PathVariable long memberId) {
		memberService.deleteOneMember(memberId);

		return new ApiResponse();
	}

	@PutMapping("/members/{memberId}")
	public ApiResponse updateOneMemberApi(@PathVariable long memberId, @RequestBody Member board) {
		Member originMember = memberService.findOneMember(memberId);
		if (originMember == null) {
			return new ApiResponse(ApiErrors.NO_DATA);
		}

		board.setIndex(memberId);
		Member updatedMember = memberService.updateOneMember(board);

		ApiDataResponse<Member> result = new ApiDataResponse<>(updatedMember);
		return result;
	}

}
