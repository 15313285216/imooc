package com.imooc.test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.imooc.dynamic.Impl.AtLogServiceImpl;
import com.imooc.dynamic.service.AtService;
import com.imooc.dynamic.service.MyBeanFactory;
import com.imooc.dynamic.service.UserService;

public class SpringTest {

   @Test
   public void add(){
       AtService atService = new AtLogServiceImpl();
       int result = atService.add(1 , 2);
       System.out.println(result);
   }
   
   @Test
   public void model(){
	   UserService userService = MyBeanFactory.createService();
	   userService.addUser();
	   
   }
   
   public static void main(String[] args) {
	   /*List<String> platformList = new ArrayList<String>();
	    platformList.add("博客园");
	    platformList.add("CSDN");
	    platformList.add("掘金");
	    
	    Iterator<String> iterator = platformList.iterator();
	    
	    while(iterator.hasNext()) {
	    	String next = iterator.next();
	    	if(next.equals("CSDN")){
	    		iterator.remove();
	    	}
	    }
	    
	   System.err.println(platformList);*/
	   
	  /*Collection<Person> collection = new ArrayList();
	  collection.add(new Person("张三", 22, "男"));
	  collection.add(new Person("李四", 19, "女"));
	  collection.add(new Person("王五", 34, "男"));
	  collection.add(new Person("赵六", 30, "男"));
	  collection.add(new Person("田七", 25, "女"));
	  
	   Stream<Person> personStream = collection.stream().filter(
	           person -> "男".equals(person.getGender())//只保留男性
	  );
	  
	  collection = personStream.collect(Collectors.toList());//将Stream转化为List
	  System.out.println(collection.toString());//查看结果*/ 
	  /*Consumer<String> con = e -> System.err.println("sldflsd" + e);
	  con.accept("werwerew");*/
	   
	  /*Comparator<Integer> com = (x,y) -> {System.err.println("函数式接口"); return Integer.compare(x, y);};
	  int compare = com.compare(100, 244);
	  System.err.println(compare);*/
	   
	   /*Supplier<String> supplier = () -> "323435434".substring(0, 3);
	   System.err.println(supplier.get());*/
	   
	   /*Function<String, String> function = (x) -> x.substring(0, 2);
	   System.err.println(function.apply("我是中国人"));*/
	   
	   /*Predicate<String> pre = (x) -> x.length() > 5;
	   System.err.println( pre.test("456789"));
	   System.err.println( pre.test("123"));*/
  }
}
