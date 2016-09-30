package com.restasync.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("async")
public class AsyncAPI {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public void getDataAsync(@Suspended AsyncResponse response) {
		
		new Thread(()->{
			System.out.println("Running Task");
			try {Thread.sleep(2000);} catch (InterruptedException e) {}
			System.out.println("Task Done");
			response.resume(Response.status(Status.OK).build());
		}).start();
		
	}

}
