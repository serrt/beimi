package com.beimi.web.handler.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.beimi.util.Menu;
import com.beimi.web.handler.Handler;
import com.beimi.web.service.repository.jpa.SysDicRepository;
import com.beimi.web.service.repository.jpa.UserRepository;

@Controller
public class AdminController extends Handler{
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRepository userRes;
	
	
	@Autowired
	private SysDicRepository sysDicRes ;
	
    @RequestMapping("/admin/content")
    @Menu(type = "admin" , subtype = "content")
    public ModelAndView content(ModelMap map , HttpServletRequest request) {
    	return request(super.createAdminTempletResponse("/admin/desktop/index"));
    }
}