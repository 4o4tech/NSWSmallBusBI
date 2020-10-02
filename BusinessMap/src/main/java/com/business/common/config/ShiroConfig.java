//package com.business.common.config;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//
///**
// * Shiro的配置类
// * @author lenovo
// *
// */
//@Configuration
//public class ShiroConfig {
//
//	/**
//	 * 创建ShiroFilterFactoryBean
//	 */
//	@Bean
//	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
//		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//		
//		//设置安全管理器
//		shiroFilterFactoryBean.setSecurityManager(securityManager);
//		
//		//添加Shiro内置过滤器
//		/**
//		 * Shiro内置过滤器，可以实现权限相关的拦截器
//		 *    常用的过滤器：
//		 *       anon: 无需认证（登录）可以访问
//		 *       authc: 必须认证才可以访问
//		 *       user: 如果使用rememberMe的功能可以直接访问
//		 *       perms： 该资源必须得到资源权限才可以访问
//		 *       role: 该资源必须得到角色权限才可以访问
//		 */
//		Map<String,String> filterMap = new LinkedHashMap<String,String>();
//		
////		filterMap.put("/statis", "authc");
////		filterMap.put("/toUpload", "authc");
//		
//		//放行login页面
//		filterMap.put("/tologin", "anon");
//		filterMap.put("/login", "anon");
//		filterMap.put("/updatePassword", "anon");
////		filterMap.put("/toIndex", "anon");
////		filterMap.put("/statis/findIncurredPrice", "anon");
////		filterMap.put("/statis/findBudget", "anon");
////		filterMap.put("/logout", "authc");
////		filterMap.put("/logout", "anon");  
//		//授权过滤器
//		//注意：当前授权拦截后，shiro会自动跳转到未授权页面(换成查询数据库，拼接字符串！！！！！！)
////		filterMap.put("/index", "perms[user:index]");
////		filterMap.put("/toUpload", "perms[user:toUpload]");
////		filterMap.put("/user/tousermanage", "perms[user:tousermanage]");
////		filterMap.put("/role/torolemanage", "perms[user:torolemanage]");
////		filterMap.put("/statis", "perms[user:statis]");
//		
//		filterMap.put("/*", "authc");
//		
//		//修改调整的登录页面
//		shiroFilterFactoryBean.setLoginUrl("/tologin");
//		//设置未授权提示页面
//		//shiroFilterFactoryBean.setUnauthorizedUrl("/toNo");
//		
//		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
//		
//		
//		return shiroFilterFactoryBean;
//	}
//	
//	/**
//	 * 创建DefaultWebSecurityManager
//	 */
//	@Bean(name="securityManager")
//	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
//		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//		//关联realm
//		securityManager.setRealm(userRealm);
//		return securityManager;
//	}
//	
//	/**
//	 * 创建Realm
//	 */
//	@Bean(name="userRealm")
//	public UserRealm getRealm(){
//		return new UserRealm();
//	}
//	
//	
//}
