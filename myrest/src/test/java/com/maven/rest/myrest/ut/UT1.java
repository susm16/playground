package com.maven.rest.myrest.ut;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.maven.rest.myrest.Node;

public class UT1 {

	@Test
	public void testnode(){
		Node n = new Node();
		n.setData(10);
		n.setName("Suma");
		
		System.out.println(n.getData());
		System.out.println(n.getName());
		n.next = null;
		System.out.println(n);
		assertTrue(n.toString().contains("Suma"));
	}
	
}
