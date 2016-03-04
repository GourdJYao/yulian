package com.yaojian.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yaojian.model.User;
import com.yaojian.service.UserService;

@Controller
@RequestMapping("/registeruser")
public class RegisterUserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取所有用户列表
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/registerUser" ,method={RequestMethod.POST})
	public void registerUser(String username,String password,String email,HttpServletRequest request,
			HttpServletResponse response){
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		User tempUser=userService.findByUser(user);
		String result = "";
		PrintWriter out = null;
		if(tempUser!=null){
			result = "fail;用户已存在";
		}else{
			userService.save(user);
			result = "success";
		}
		try {
			System.out.println("result:"+result);
			out = response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
				out = null;
			}
		}
	}
}
