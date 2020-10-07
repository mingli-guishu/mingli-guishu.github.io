package com.zqy20190926;

public class Book {
	String name;
	int page;
	int a=2;
	
	public void Read(){
		System.out.println(name+"正在被阅读");
		
	}
	public void Lasting(int mins){
		System.out.println("阅读持续了"+mins+"分钟");
		if(a==3&&++a==3){
			System.out.println(a);
		}
	}
	public void Name(){
		System.out.println("这本书叫"+name);
	}
	
	public static void main(String[] args){
		Book A=new Book();
		A.name="MagicBean";
		A.page=233;
		System.out.println("这本书的名字叫"+A.name);//这本书叫MagicBean
		System.out.println(A.name+"的页数为"+A.page+"页");
		A.Read();
		int times=51;
		A.Lasting(times);	
	}
}
