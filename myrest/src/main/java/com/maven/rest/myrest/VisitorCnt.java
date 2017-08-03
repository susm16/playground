package com.maven.rest.myrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.maven.rest.myrest.Node;

@Path("/visitors")
public class VisitorCnt {

	private static int cnt = 0;
	private static Client client = ClientBuilder.newClient();
	private static String target = "http://localhost:8123/myrest/";
	
	
	@GET
	public Response getVisitors(){
	
		Response res =client.target(target).path("/mylist/printlist").request().get();
		return Response.status(200).entity(res.readEntity(String.class)).build();
	}
	
	
	@GET
	@Path("/register/{name}")
	public Response getVisitorCnt(@PathParam("name") String n){
		cnt++;
		Node emp = new Node();
		emp.setName(n);
		emp.setData(cnt);
	
		
		String res =client.target(target)
							.path("/mylist/add")
							.request()
							.post(Entity.entity(emp, MediaType.APPLICATION_JSON),String.class);
		
		
		return Response.status(200).entity(n+" is visitor no."+cnt+"***"+res).build();
	}
}
