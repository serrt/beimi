package com.beimi.web.handler.api;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beimi.core.BMDataContext;
import com.beimi.util.UKTools;
import com.beimi.util.cache.CacheHelper;
import com.beimi.web.handler.Handler;
import com.beimi.web.model.User;
import com.beimi.web.service.repository.UserRepository;

@RestController
@RequestMapping("/tokens")
public class ApiLoginController extends Handler{
	
	@Autowired
	private UserRepository userRepository;

    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(HttpServletRequest request , HttpServletResponse response , @Valid User user) {
    	User loginUser = userRepository.findByUsernameAndPassword(user.getUsername() , UKTools.md5(user.getPassword())) ;
    	ResponseEntity entity = null ;
        if(loginUser!=null && !StringUtils.isBlank(loginUser.getId())){
        	loginUser.setLogin(true);
        	loginUser.setLastlogintime(new Date());
        	if(!StringUtils.isBlank(loginUser.getId())){
        		userRepository.save(loginUser) ;
        	}
        	String auth = UKTools.getUUID();
        	CacheHelper.getApiUserCacheBean().put(auth, loginUser, BMDataContext.SYSTEM_ORGI);
        	entity = new ResponseEntity<>(auth, HttpStatus.OK) ;
        	response.addCookie(new Cookie("authorization",auth));
        }else{
        	entity = new ResponseEntity<>(HttpStatus.UNAUTHORIZED) ;
        }
        return entity;
    }
    
    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity error(HttpServletRequest request) {
        return new ResponseEntity<>(super.getUser(request) , HttpStatus.OK);
    }

    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity logout(HttpServletRequest request , @RequestHeader(value="authorization") String authorization) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}