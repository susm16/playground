package com.maven.rest.myrest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/mylist")
public class Mylist {

	private static Node head = null;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public Response add(Node n){
		//Node temp = new Node(d);
	
		if(head==null){
			head = n;
			return Response.status(200).entity("Added first node to the list successfully").build();
		}
		else{
			Node cur = head;
			while(cur.next!=null){
				cur = cur.next;
			}
			cur.next = n;
			return Response.status(200).entity("Data added to list successfully").build();
		}
	}
	
	@DELETE
	@Path("/trim")
	public Response remove(){
		Node cur = head;
		Node p_cur = null;
		
		String details = null;
		
		if(head==null){
			return Response.status(200).entity("Empty list nothing to delete").build();
		}
		if(head.next==null){
			details = head.toString();
			head = null;
			return Response.status(200).entity("Last item to be deleted is |"+details).build();
		}
		else{
			while(cur.next!=null){
				p_cur = cur;
				cur = cur.next;
			}
			details = cur.toString();
			p_cur.next = null; 
		}
		return Response.status(200).entity("Deleted item is |"+details).build();
	}
	
	@GET
	@Path("/printlist")
	public Response display(){
		Node cur = head;
		
		if(head == null){
			System.out.println("Empty list!!!");
			return Response.status(200).entity("empty list").build();
		}
		
		StringBuilder output = new StringBuilder("");
		while(cur!=null){
			System.out.println(cur.toString());
            output.append(cur.toString()).append("\n");
			cur = cur.next;
		}
		
		return Response.status(200).entity(output.toString()).build();
	}
	
	@PUT
	@Path("/reverse")
	public Response reverse(){
		if(head==null){
			return Response.status(200).entity("Empty list").build();
		}
		if(head.next==null){
			return Response.status(200).entity("Only one element in the list").build();
		}
		else{
			Node cur_n = null;
			Node cur = head;
			Node r_head = null;
			while(cur!=null){
				cur_n = cur.next;
				cur.next = r_head;
				r_head = cur;
				cur = cur_n;
			}
			head = r_head;
			cur = head;
			StringBuilder output = new StringBuilder("");
			while(cur!=null){
				System.out.println(cur.toString());
	            output.append(cur.toString()).append("\n");
				cur = cur.next;
			}
			
			System.out.println("****"+output+"****");
			return Response.status(200).entity(output.toString()).build();
		}
		
	}
	
}
