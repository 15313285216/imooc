package com.imooc.dynamic.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.imooc.dynamic.Impl.UserServiceImpl;

public class MyBeanFactory {

	public static UserService createService(){
		final MyAspect aspect = new MyAspect();
		final UserService service = new UserServiceImpl();
		
		UserService newProxyInstance = (UserService)Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), service.getClass().getInterfaces(),
				new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				aspect.before();
				Object invoke = method.invoke(service, args);
				aspect.after();
				
				return invoke;
			}
		});
		
		return newProxyInstance;
	}
}
