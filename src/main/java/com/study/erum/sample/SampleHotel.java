package com.study.erum.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

//toString 사용이유 : 클래스안에 있는변수들(여러개의값)을 한번에 주기위해서.
@Component
@ToString
@Getter
public class SampleHotel {
	
	private Chef chef;
	
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
	
}
