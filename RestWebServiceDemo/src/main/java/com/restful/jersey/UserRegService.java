package com.restful.jersey;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/user-form")
public class UserRegService {
	@POST
    @Path("/register")
    public Response registerUserInfo(@FormParam("name") String name,
                                    @FormParam("address") String address){         
        String response = "Successfully added user details, name: "+
                            name+" and address: "+address;
        return Response.status(200).entity(response).build();
    } 
	
	
}
