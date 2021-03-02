package edu.bit.ex.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.bit.ex.service.UserService;
import edu.bit.ex.vo.MemberUser;
import edu.bit.ex.vo.MemberVO;
import edu.bit.ex.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */

@Log4j
@AllArgsConstructor
@Controller
public class UserController {

	private UserService userService;

	@GetMapping("/user/userForm")
	public void userForm() {
		log.info("Welcome userForm");
	}

	@PostMapping("/user/addUser")
	public String addUser(UserVO uservo) {
		log.info("post resister");
		userService.addUser(uservo);

		return "redirect:/";
	}

	/*
	 * @GetMapping("/loginInfo") public String loginInfo(Principal principal) {
	 * 
	 * System.out.println("controller에서 principal 객체 호출"); // 1.Controller를 통하여
	 * Pincipal객체로 가져오는 방법 String user_id = principal.getName();
	 * System.out.println("유저 아이디:" + user_id);
	 * 
	 * System.out.println(); System.out.println("SpringContextHolder 통해"); //
	 * 2.SpringContextHolder를 통하여 가져오는 방법(일반적인 빈에서 사용 할수있음 ) Authentication auth =
	 * SecurityContextHolder.getContext().getAuthentication(); user_id =
	 * auth.getName(); System.out.println("유저 아이디:" + user_id);
	 * 
	 * System.out.println(); System.out.println("UserDetails 통해"); // 3. UserDetails
	 * userDetails = (UserDetails) auth.getPrincipal();
	 * System.out.println(userDetails.getUsername());
	 * 
	 * System.out.println(); System.out.println("MemberUser(User)객체 통해"); // 4.
	 * MemberUser memberUser = (MemberUser) auth.getPrincipal();
	 * System.out.println(memberUser.getPassword());
	 * 
	 * System.out.println();
	 * System.out.println("SpringContextHolder 를 User 객체로 변환"); // 5.User 클래스로 변환 하여
	 * 가져오는 방법 User user = (User)
	 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 * user_id = user.getUsername(); System.out.println("유저 아이디:" + user_id);
	 * 
	 * return "home";
	 * 
	 * }
	 */
	

}
