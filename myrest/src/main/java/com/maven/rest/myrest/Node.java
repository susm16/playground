package com.maven.rest.myrest;

public class Node {

	private int data;
	private String name;
	public Node next;
	

	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


   public String toString(){

	   return getData()+"|"+getName();
	   
   }
	
}
