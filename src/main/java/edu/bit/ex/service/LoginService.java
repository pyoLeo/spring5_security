package edu.bit.ex.service;

import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.LogInMapper;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LoginService {	

	LogInMapper logInMapper;
	
	public UserVO loginUser(String id,String pw)  {
		return logInMapper.logInUser(id,pw) ;
	}

}
