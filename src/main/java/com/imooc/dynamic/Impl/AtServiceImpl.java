package com.imooc.dynamic.Impl;

import com.imooc.dynamic.service.AtService;

public class AtServiceImpl implements AtService {

	 public int add(int a, int b) {
	   int result = a + b;
	   return result;
	 }
	 public int min(int a, int b) {
	   int result = a - b;
	   return result;
	 }
	 public int mul(int a, int b) {
	   int result = a * b;
	   return result;
	 }
	 public int div(int a, int b) {
	   int result = a / b;
	   return result;
	 }
	 public int add(int a, int b, int c) {
	   int result = a + b + c;
	   return result;
	 }

}
