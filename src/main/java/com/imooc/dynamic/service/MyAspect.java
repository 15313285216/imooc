package com.imooc.dynamic.service;

/**
 * 切面类
 * @author Administrator
 *
 */
public class MyAspect {

	 public void before(){
	     System.out.println("执行前");
	  }
	  public void after(){
	     System.out.println("执行后");
	  }
}
