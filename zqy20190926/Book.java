package com.zqy20190926;

public class Book {
	String name;
	int page;
	int a=2;
	
	public void Read(){
		System.out.println(name+"���ڱ��Ķ�");
		
	}
	public void Lasting(int mins){
		System.out.println("�Ķ�������"+mins+"����");
		if(a==3&&++a==3){
			System.out.println(a);
		}
	}
	public void Name(){
		System.out.println("�Ȿ���"+name);
	}
	
	public static void main(String[] args){
		Book A=new Book();
		A.name="MagicBean";
		A.page=233;
		System.out.println("�Ȿ������ֽ�"+A.name);//�Ȿ���MagicBean
		System.out.println(A.name+"��ҳ��Ϊ"+A.page+"ҳ");
		A.Read();
		int times=51;
		A.Lasting(times);	
	}
}
