package com.beimi.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.beimi.core.BMDataContext;
import com.beimi.util.event.UserDataEvent;
import com.beimi.util.event.UserEvent;
import com.lmax.disruptor.dsl.Disruptor;


public class UKTools {
	private static MD5 md5 = new MD5();
	
	public static SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
	
	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
	
	public static SimpleDateFormat timeRangeDateFormat = new SimpleDateFormat("HH:mm");
	
	/**
	 * 当前时间+已过随机生成的 长整形数字
	 * @return
	 */
	public static String genID(){
		return Base62.encode(getUUID()).toLowerCase() ;
	}
	
	public static String genIDByKey(String key){
		return Base62.encode(key).toLowerCase() ;
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "") ;
	}
	
	public static String getContextID(String session){
		return session.replaceAll("-", "") ;
	}
	
	public static String md5(String str) {
		return md5.getMD5ofStr(md5.getMD5ofStr(str));
	}
	
	public static String md5(byte[] bytes) {
		return md5.getMD5ofByte(bytes);
	}
	
	public static void copyProperties(Object source, Object target,String... ignoreProperties)  
	        throws BeansException {  
	  
	    Assert.notNull(source, "Source must not be null");  
	    Assert.notNull(target, "Target must not be null");  
	  
	    Class<?> actualEditable = target.getClass();  
	    PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);  
	    List<String> ignoreList = (ignoreProperties != null) ? Arrays.asList(ignoreProperties) : null;  
	  
	    for (PropertyDescriptor targetPd : targetPds) {  
	        Method writeMethod = targetPd.getWriteMethod();  
	        if (writeMethod != null && (ignoreProperties == null || (!ignoreList.contains(targetPd.getName())))) {  
	            PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());  
	            if (sourcePd != null && !targetPd.getName().equalsIgnoreCase("id")) {  
	                Method readMethod = sourcePd.getReadMethod();  
	                if (readMethod != null &&  
	                        ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {  
	                    try {  
	                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {  
	                            readMethod.setAccessible(true);  
	                        }  
	                        Object value = readMethod.invoke(source);  
	                        if(value != null){  //只拷贝不为null的属性 by zhao  
	                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {  
	                                writeMethod.setAccessible(true);  
	                            }  
	                            writeMethod.invoke(target, value);  
	                        }  
	                    }  
	                    catch (Throwable ex) {  
	                        throw new FatalBeanException(  
	                                "Could not copy property '" + targetPd.getName() + "' from source to target", ex);  
	                    }  
	                }  
	            }  
	        }  
	    }  
	}  
	
	public static long ipToLong(String ipAddress) {
		long result = 0;
		String[] ipAddressInArray = ipAddress.split("\\.");
		if(ipAddressInArray!=null && ipAddressInArray.length == 4){
			for (int i = 3; i >= 0; i--) {
				long ip = Long.parseLong(ipAddressInArray[3 - i]);
	
				// left shifting 24,16,8,0 and bitwise OR
	
				// 1. 192 << 24
				// 1. 168 << 16
				// 1. 1 << 8
				// 1. 2 << 0
				result |= ip << (i * 8);
	
			}
		}
		return result;
	}

	public static String longToIp2(long ip) {

		return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "."
				+ ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
	}
	/***
	 * ID编码 ， 发送对话的时候使用
	 * @param id
	 * @param nid
	 * @return
	 */
	public static String genNewID(String id , String nid){
		StringBuffer strb = new StringBuffer();
		if(id!=null && nid!=null){
			int length = Math.max(id.length(), nid.length()); 
			for(int i=0 ; i<length ; i++){
				if(nid.length() > i && id.length() > i){
					int cur = (id.charAt(i) + nid.charAt(i)) / 2 ;
					strb.append((char)cur) ;
				}else if(nid.length() > i){
					strb.append(nid.charAt(i)) ;
				}else{
					strb.append(id.charAt(i)) ;
				}
			}
		}
		return strb.toString() ;
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getParameter(HttpServletRequest request){
		Enumeration<String> names = request.getParameterNames() ;
		StringBuffer strb = new StringBuffer();
		while(names.hasMoreElements()){
			String name = names.nextElement() ;
			if(name.indexOf("password") < 0){	//不记录 任何包含 password 的参数内容
				if(strb.length() > 0){
					strb.append(",") ;
				}
				strb.append(name).append("=").append(request.getParameter(name)) ;
			}
		}
		return strb.toString() ;
		
	}
	
	/**
	 * 获取一天的开始时间
	 * @return
	 */
	public static Date getStartTime(){
		Calendar todayStart = Calendar.getInstance();  
        todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime();  
	}
	
	/**
	 * 获取一天的开始时间
	 * @return
	 */
	public static Date getWeekStartTime(){
		Calendar weekStart = Calendar.getInstance();  
		weekStart.set(weekStart.get(Calendar.YEAR), weekStart.get(Calendar.MONDAY), weekStart.get(Calendar.DAY_OF_MONTH), 0, 0, 0);  
		weekStart.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
        return weekStart.getTime();  
	}
	
	/**
	 * 获取一天的开始时间
	 * @return
	 */
	public static Date getLast30Day(){
		Calendar todayStart = Calendar.getInstance();  
		todayStart.set(Calendar.DAY_OF_MONTH, -30);
		todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime();  
	}
	
	/**
	 * 获取一天的开始时间
	 * @return
	 */
	public static Date getLastDay(int days){
		Calendar todayStart = Calendar.getInstance();  
		todayStart.set(Calendar.DAY_OF_MONTH, -days);
		todayStart.set(Calendar.HOUR_OF_DAY, 0);  
        todayStart.set(Calendar.MINUTE, 0);  
        todayStart.set(Calendar.SECOND, 0);  
        todayStart.set(Calendar.MILLISECOND, 0);  
        return todayStart.getTime();  
	}
	
	/**
	 * 获取一天的结束时间
	 * @return
	 */
	public static Date getEndTime(){
		Calendar todayEnd = Calendar.getInstance();  
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);  
        todayEnd.set(Calendar.MINUTE, 59);  
        todayEnd.set(Calendar.SECOND, 59);  
        todayEnd.set(Calendar.MILLISECOND, 999);  
        return todayEnd.getTime();  
	}
	
	/**
	 * 获取一天的结束时间
	 * @return
	 */
	public static Date getLastTime(int secs){
		Calendar todayEnd = Calendar.getInstance();
        todayEnd.add(Calendar.SECOND, secs*-1);  
        return todayEnd.getTime();  
	}
	
	public static void noCacheResponse(HttpServletResponse response){
		response.setDateHeader("Expires",0);
        response.setHeader("Buffer","True");
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Cache-Control","no-store");
        response.setHeader("Expires","0");
        response.setHeader("ETag",String.valueOf(System.currentTimeMillis()));
        response.setHeader("Pragma","no-cache");
        response.setHeader("Date",String.valueOf(new Date()));
        response.setHeader("Last-Modified",String.valueOf(new Date()));
	}
	
	public static Map<String, Object> transBean2Map(Object obj) {  
		  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法 
                	
                    Method readMethod = property.getReadMethod(); 
                    
                    if (readMethod != null) {  
                    	Object value = readMethod.invoke(obj);  
                    	if(value instanceof Date){
                    		value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) value) ;
                    	}
	                    map.put(key, value);
	                }  
                }  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
  
        return map;  
  
    }
	
	/**
     * 
     * @param str
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public static String encryption(String str) throws NoSuchAlgorithmException{
    	BasicTextEncryptor  textEncryptor = new BasicTextEncryptor ();
    	textEncryptor.setPassword(BMDataContext.getSystemSecrityPassword());
    	return textEncryptor.encrypt(str);
    }
    
    /**
     * 
     * @param str
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public static String decryption(String str) throws NoSuchAlgorithmException{
    	BasicTextEncryptor  textEncryptor = new BasicTextEncryptor ();
    	textEncryptor.setPassword(BMDataContext.getSystemSecrityPassword());
    	return textEncryptor.decrypt(str);
    }
    
    public static String getTopic(String snsid ,String msgtype , String eventype , String eventkey , String msg){
    	StringBuffer strb = new StringBuffer() ;
		strb.append(snsid) ;
		strb.append(".").append(msgtype) ;
		if(msgtype.equals("text")){
			strb.append(".").append(msg) ;
		}else if(msgtype.equals("event")){
			strb.append(".").append(eventype.toLowerCase()) ;
			if(!StringUtils.isBlank(eventkey)){
				strb.append(".").append(eventkey) ;
			}
		}else{
			strb.append(".").append(msgtype) ;
		}
		return strb.toString() ;
    }
    
    public static String getTopic(String snsid ,String msgtype , String eventype){
    	StringBuffer strb = new StringBuffer() ;
		strb.append(snsid) ;
		strb.append(".").append(msgtype) ;
		if(msgtype.equals("text")){
			strb.append(".").append(msgtype) ;
		}else if(msgtype.equals("event")){
			strb.append(".").append(eventype.toLowerCase()) ;
		}else{
			strb.append(".").append(msgtype) ;
		}
		return strb.toString() ;
    }
	/**
	 * 处理 对话消息中的图片
	 * @param message
	 * @return
	 */
    public static String filterChatMessage(String message){
    	Document document = Jsoup.parse(message) ;
    	Elements pngs = document.select("img[src]");
    	for (Element element : pngs) {
    		String imgUrl = element.attr("src");
    		if(imgUrl.indexOf("/res/image") >= 0){
    			element.attr("class", "ukefu-media-image") ;
    		}
    	}
    	return document.html() ;
    }
    
    /**
     * 检查当前时间是否是在 时间范围内 ，时间范围的格式为 ： 08:30~11:30,13:30~17:30
     * @param timeRanges
     * @return
     */
    public static boolean isInWorkingHours(String timeRanges){
    	boolean workintTime = true ;
    	String timeStr = timeRangeDateFormat.format(new Date()) ;
    	if(!StringUtils.isBlank(timeRanges)){		//设置了 工作时间段
    		workintTime = false ;					//将 检查结果设置为 False ， 如果当前时间是在 时间范围内，则 置为 True
    		String[] timeRange = timeRanges.split(",") ;
    		for(String tr : timeRange){
    			String[] timeGroup = tr.split("~") ;
    			if(timeGroup.length == 2){
    				if(timeGroup[0].compareTo(timeGroup[1]) >= 0){
    					if(timeStr.compareTo(timeGroup[0]) >= 0 || timeStr.compareTo(timeGroup[1]) <= 0){
	    					workintTime = true ;
	    				}
    				}else{
	    				if(timeStr.compareTo(timeGroup[0]) >= 0 && timeStr.compareTo(timeGroup[1]) <= 0){
	    					workintTime = true ;
	    				}
    				}
    			}
    		}
    	}
    	return workintTime ;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void published(UserEvent event , ElasticsearchCrudRepository esRes , JpaRepository dbRes){
		Disruptor<UserDataEvent> disruptor = (Disruptor<UserDataEvent>) BMDataContext.getContext().getBean("disruptor") ;
		long seq = disruptor.getRingBuffer().next();
		UserDataEvent userDataEvent = disruptor.getRingBuffer().get(seq) ;
		userDataEvent.setEvent(event);
		userDataEvent.setDbRes(dbRes);
		userDataEvent.setEsRes(esRes);
		disruptor.getRingBuffer().publish(seq);
	}
}
