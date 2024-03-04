package com.study.erum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.erum.dto.MemberDTO;
import com.study.erum.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor //생성자 주입 요즘은 생성자 주입을 쓴다.
public class MemberController {
	
	private final MemberService memberService; 
	
//  @Autowird
//	private final MemberService memberService;
	
	@GetMapping("/save")
	public String saveForm() {
		System.out.println("save 컨드롤러 실행");
		return "save";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute MemberDTO memberDTO) {
		//@ManagedAttribute 데이터 베이스 안에 있는값을 여기로 넘겨줘라..
		int saveResult = memberService.save(memberDTO);
		if(saveResult>0) {
			return "login";
		}else {
			return "save";
		}
	}
	
}
