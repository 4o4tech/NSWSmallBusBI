//package com.business.common.config;
//
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import shopping.manage.entity.User;
//import shopping.manage.service.IUserService;
//
//
//public class UserRealm extends AuthorizingRealm {
////	@Autowired
////	private IDSystemMenuService iDSystemMenuService;
////	
////	@Autowired
////	private IDSystemUserService iDSystemUserService;
//	@Autowired
//	private IUserService userService;
//	/**
//	 * 执行授权逻辑
//	 */
////	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//		/*
//		 * System.out.println("执行授权逻辑");
//		 */
//		// 给资源进行授权
//		// 给资源进行授权
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//		// 添加资源的授权字符串
//		// info.addStringPermission("user:add");
//
//		// 到数据库查询当前登录用户的授权字符串
////				//获取当前登录用户
////				Subject subject = SecurityUtils.getSubject();
////				DSystemUser user = (DSystemUser)subject.getPrincipal();
////				
//////				System.out.println(roleid);
////				List<String> l=iDSystemMenuService.findById(user.getId());
////				//返回集合
////				for (String string : l) {
////					info.addStringPermission(string);
////				}
////				return info;
//		return null;
//
//	}
//
//	/**
//	 * 执行认证逻辑
//	 */
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
//		System.out.println("执行认证逻辑");
//		//1.判断用户名
//		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
//		User user=userService.findUserByUserNum(token.getUsername());
//		if(user==null){
//			//用户名不存在
//			return null;//shiro底层会抛出UnKnowAccountException
//		}
//		// 2.判断密码
//		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
//	}
//
//}
