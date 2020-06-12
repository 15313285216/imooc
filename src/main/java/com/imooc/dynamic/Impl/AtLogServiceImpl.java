package com.imooc.dynamic.Impl;

import com.imooc.dynamic.service.AtService;

public class AtLogServiceImpl implements AtService {
	
	private AtService atService = new AtServiceImpl();

   public int add(int a , int b ) {
       int result = atService.add(a , b);
       System.out.println("你输入的参数为"+a+"和"+b+"；相加结果为"+result);
       return result;
   }
   
   public int min(int a , int b ) {
       int result = atService.min(a , b);
       System.out.println("你输入的参数为"+a+"和"+b+"；相减结果为"+result);
       return result;
   }
   
   public int mul(int a , int b ) {
       int result = atService.mul(a , b);
       System.out.println("你输入的参数为"+a+"和"+b+"；相乘结果为"+result);
       return result;
   }
   
   public int div(int a , int b ) {
       int result = atService.div(a , b);
       System.out.println("你输入的参数为"+a+"和"+b+"；相除结果为"+result);
       return result;
   }
   public int add(int a , int b , int c ) {
       int result = atService.add( a,  b,  c);
       System.out.println("你输入的参数为"+a+"和"+b+"和"+c+"；相加结果为"+result);
       return result;
   }
}
