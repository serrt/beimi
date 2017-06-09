package com.beimi.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beimi.web.model.User;
import com.beimi.web.service.repository.UserRepository;

  
@RestController  
@RequestMapping("/user")  
public class UserController { 
	
	@Autowired
	private UserRepository userRes;
  
	@RequestMapping("/{id}")  
    public User view(@PathVariable("id") String id) {  
        User user = new User();  
        user.setId(id);  
        
        userRes.save(user) ;
        
        System.out.println(user.getEmail());

        return user;  
    }  
  
}  
