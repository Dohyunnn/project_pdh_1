package com.kor.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kor.exam.demo.service.MemberService;
import com.kor.exam.demo.vo.Member;

@Controller
public class UsrMemberController {	
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}


	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Member doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo, String email) {
		int id = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		
		Member member = (Member) memberService.getMemberById(id);
		
		return member;
	}
}