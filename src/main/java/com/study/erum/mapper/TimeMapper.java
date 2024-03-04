package com.study.erum.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("SELECT CURRENT_DATE FROM dual") //기능이 제한적이기 때문에 복잡한거못짠다.
	public String getTime();
	
	public String getTime2();
}
