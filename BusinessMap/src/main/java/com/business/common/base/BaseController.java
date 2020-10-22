package com.business.common.base;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
//	@Value("${file.uploadFolder}")
//    public String uploadFolder;
//    @Value("${file.tempFolder}")
//    public String tempFolder;
    protected static final String LINK_JSP = "manage/common/message";
    public static final String HANDLE_SUCCESS="操作成功";
    public static final String HANDLE_FAIL="操作失败";
    
//    /**
//     * 登录认证异常
//     */
//    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
//    public ResponseResult authenticationException(HttpServletRequest request, HttpServletResponse response) {
//    	ResponseResult result=new ResponseResult();
//    	result.setData("nologin");
//    	return result;
//    }


}
