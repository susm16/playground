package com.maven.rest.myrest.it;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientResponse;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.maven.math.MathHelper.*;

public class TestScenarios1 {

	@Test
	public void testvcnt0(){
		
		JerseyClient client = JerseyClientBuilder.createClient();
		
		Response res = client.target("http://localhost:8123/myrest")
		.path("/visitors").request(MediaType.TEXT_PLAIN).get();
		//System.out.println(res.readEntity(String.class));
		assertTrue(res.readEntity(String.class).contains("empty"));
	}
	
	@Test
	public void testvcnt1(){
		
		JerseyClient client = JerseyClientBuilder.createClient();
		
		Response res = client.target("http://localhost:8123/myrest")
		.path("/visitors/register/suma").request(MediaType.TEXT_PLAIN).get();
		//System.out.println(res.readEntity(String.class));
		assertTrue(res.readEntity(String.class).contains("suma is visitor no.1***Added first node to the list successfully"));
	}
	
	@Test
	public void testvcnt2(){
		
		JerseyClient client = JerseyClientBuilder.createClient();
		
		Response res = client.target("http://localhost:8123/myrest")
		.path("/visitors/register/bob").request(MediaType.TEXT_PLAIN).get();
		//System.out.println(res.readEntity(String.class));
		
		assertTrue(res.readEntity(String.class).contains("bob is visitor no.2***Data added to list successfully"));
	}
	
	
	@Test
	public void testvcnt3(){
		
		JerseyClient client = JerseyClientBuilder.createClient();
		
		Response res = client.target("http://localhost:8123/myrest")
		.path("/visitors/register/sam").request(MediaType.TEXT_PLAIN).get();
		//System.out.println(res.readEntity(String.class));
		
		assertTrue(res.readEntity(String.class).contains("sam is visitor no.3***Data added to list successfully"));
	}
	
	@Test
	public void testvcnt4(){
JerseyClient client = JerseyClientBuilder.createClient();
		
		Response res = client.target("http://localhost:8123/myrest")
		.path("/visitors").request(MediaType.TEXT_PLAIN).get();
	}
	
	@Test
	public void testMathadd(){
		Calculator helper = new Calculator();
		helper.add(10, 20);
	}
	
	@Test
	public void testMathsub(){
		Calculator helper = new Calculator();
		helper.subtract(10, 20);
	}
	
	@Test
	public void testMathmul(){
		Calculator helper = new Calculator();
		helper.multiple(10, 20);
	}
	
	@Test
	public void testMathdiv(){
		Calculator helper = new Calculator();
		helper.divide(10, 20);
	}
}
