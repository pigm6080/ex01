package com.study.erum.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
			//성공하면열로가라
			return "login";
		}else {
			return "save";
		}
	}
	@GetMapping("/login")
	public String loginForm() {
		System.out.println("login 컨드롤러 실행");
		return "login";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
		//@ManagedAttribute 데이터 베이스 안에 있는값을 여기로 넘겨줘라..
		System.out.println("login메서드까지왔다.");
		boolean loginResult = memberService.login(memberDTO);
		System.out.println(loginResult);
		if(loginResult) {
			session.setAttribute("loginEmail", memberDTO.getMemberEmail());
			//성공하면열로가라
			return "main";
		}else {
			return "login";
		}
	}
	
	@GetMapping("/")
	public String findAll(Model model) {
		//@ManagedAttribute 데이터 베이스 안에 있는값을 여기로 넘겨줘라..
		List<MemberDTO> memberDTOList = memberService.findAll();
		model.addAttribute("memberList",memberDTOList);
		return "list";
	}
	
	  //member?id=1
	   @GetMapping
	   public String findById(@RequestParam("id") Long id, Model model){
	     MemberDTO memberDTO = memberService.findById(id);
	     model.addAttribute("member", memberDTO);
	     return "detail";
	   }
	   @GetMapping("/delete")
	   public String delete(@RequestParam("id") Long id){
	     memberService.delete(id);
	     return "redirect:/member/";
	   }
	   
	   @GetMapping("/update")
	   public String updateFrom(HttpSession session, Model model) {
		    String loginEmail = (String) session.getAttribute("loginEmail");
		    MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
		    model.addAttribute("member", memberDTO);
		    return "update";
	   }
	   @PostMapping("/update")
	   public String update(@ModelAttribute MemberDTO memberDTO){
	     boolean result = memberService.update(memberDTO);
	     if(result){
	       return "redirect:/member?id=" + memberDTO.getId();
	     }else{
	       return "index";
	     }
	   }
	   
	   @PostMapping("/email-check")
	   public @ResponseBody String emailCheck(@RequestParam("memberEmail")String memberEamil) {
		   System.out.println("memberEmail = " + memberEamil);
		   String checkResultString = memberService.emailCheck(memberEamil);
		   return checkResultString;
	   }
	
}
