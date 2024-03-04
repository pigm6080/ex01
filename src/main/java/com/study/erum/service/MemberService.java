package com.study.erum.service;

import org.springframework.stereotype.Service;

import com.study.erum.dto.MemberDTO;
import com.study.erum.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	  
	  public int save(MemberDTO memberDTO) {
		  
		  return memberRepository.save(memberDTO);
	  }

}
