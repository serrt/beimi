package com.beimi.web.handler.api;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beimi.core.BMDataContext;
import com.beimi.util.UKTools;
import com.beimi.util.cache.CacheHelper;
import com.beimi.web.handler.Handler;
import com.beimi.web.model.PlayUser;
import com.beimi.web.service.repository.es.PlayUserESRepository;
import com.beimi.web.service.repository.jpa.PlayUserRepository;

@RestController
@RequestMapping("/tokens")
public class ApiLoginController extends Handler{
	
	@Autowired
	private PlayUserESRepository playUserESRes;
	
	@Autowired
	private PlayUserRepository playUserRes ;

    @SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(HttpServletRequest request , HttpServletResponse response, @RequestParam String username , @RequestParam String password) {
    	PlayUser player = null ;
    	if(!StringUtils.isBlank(username) && !StringUtils.isBlank(password)){
    		player = playUserESRes.findByUsernameAndPassword(username, UKTools.md5(password)) ;
    		if(player == null){
    			player = playUserRes.findByUsernameAndPassword(username, UKTools.md5(password)) ;
//    			playUserESRes.save(player) ;
    		}
    	}
    	ResponseEntity entity = null ;
        if(player!=null && !StringUtils.isBlank(player.getId())){
        	player.setLogin(true);			//已登录
        	player.setOnline(false);		//未在游戏状态
        	player.setLastlogintime(new Date());
        	/**
        	 * 消息队列，同时存ES和数据库，或其他持久化数据系统
        	 */
        	UKTools.published(player , playUserESRes , playUserRes);
        	/**
        	 * 发送到消息队列，用户登录
        	 */
        	
        	String auth = UKTools.getUUID();
        	CacheHelper.getApiUserCacheBean().put(auth, player, BMDataContext.SYSTEM_ORGI);
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