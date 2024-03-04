package com.study.erum.repository;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


import com.study.erum.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	private final SqlSessionTemplate sql;
	
	public int save(MemberDTO memberDTO) {
		System.out.println("memberDTO = " + memberDTO);
		return sql.insert("Member.save",memberDTO);
	}

}
