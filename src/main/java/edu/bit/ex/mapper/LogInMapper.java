package edu.bit.ex.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.ex.vo.UserVO;

public interface LogInMapper {

	@Select("select * from users where username = #{username} and password = #{password}")
	public UserVO logInUser(@Param("username") String username,@Param("password") String password);
	
}
