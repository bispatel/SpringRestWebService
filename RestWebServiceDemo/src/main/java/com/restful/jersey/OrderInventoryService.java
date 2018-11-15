package com.restful.jersey;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.restful.jersey.domain.Order;
import com.restful.jersey.domain.OrderJson;

import sun.misc.BASE64Decoder;

@Path("/order-inventory")
public class OrderInventoryService {
	@GET
	@Path("/order/{orderId}")
	@Produces(MediaType.APPLICATION_XML)
	public Order getUserById(@PathParam("orderId") Integer orderId) {

		Order ord = new Order();
		ord.setOrderNo(orderId);
		ord.setCustmer("Java2Novice");
		ord.setAddress("Bangalore");
		ord.setAmount("$2000");
		return ord;
	}

	@GET
	@Path("/orderJson/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderJson getJsonData(@PathParam("orderId") Integer orderId) {
		OrderJson ord = new OrderJson();
		ord.setOrderNo(orderId);
		ord.setCustmer("Java2Novice");
		ord.setAddress("Bangalore");
		ord.setAmount("$2000");
		return ord;
	}

	@POST
	@Path("/insertOrder")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consumeJsonData(OrderJson inputOrder) {
		System.out.println("Received order from :" + inputOrder.getCustmer());
		System.out.println("Order worth: " + inputOrder.getAmount());
		System.out.println("Customer address: " + inputOrder.getAddress());
		return Response.status(200).entity("Your order is in-progress").build();
	}

	@GET
	@Path("/secureOrder/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object authenticateOrder(@PathParam("orderId") Integer orderId, @HeaderParam("authorization") String authString) {
		if (!isUserAuthenticated(authString)) {
			return "{\"error\":\"User not authenticated\"}";
		}
		OrderJson ord = new OrderJson();
		ord.setCustmer("Java");
		ord.setAddress("Bhubaneswar");
		ord.setAmount("$8000");
		return ord;
	}
	
	 private boolean isUserAuthenticated(String authString){
            String user="bishwajit";
            String pass="patel";
	        String decodedAuth = "";
	        // Header is in the format "Basic 5tyc0uiDat4"
	        // We need to extract data before decoding it back to original string
	        String[] authParts = authString.split("\\s+");
	        String authInfo = authParts[1];
	        // Decode the data back to original string
	        byte[] bytes = null;
	        try {
	            bytes = new BASE64Decoder().decodeBuffer(authInfo);
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        decodedAuth = new String(bytes);
	        System.out.println(decodedAuth);
	         
	        /**
	         * here you include your logic to validate user authentication.
	         * it can be using ldap, or token exchange mechanism or your 
	         * custom authentication mechanism.
	         */
	        // your validation code goes here....
	         if(decodedAuth.equalsIgnoreCase(user+":"+pass)) {
	        	 return true;
	         }
	        return false;
	    }
}
