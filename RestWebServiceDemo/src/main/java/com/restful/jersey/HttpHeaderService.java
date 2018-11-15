package com.restful.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/http-header")
public class HttpHeaderService {
 
    @GET
    @Path("query")
    public Response queryHeaderInfo(@HeaderParam("Cache-Control") String ccControl,
                                        @HeaderParam("User-Agent") String uaStr){
         
        String resp = "Received http headers are Cache-Control: "+ccControl+
                        "<br>User-Agent: "+uaStr;
        return Response.status(200).entity(resp).build();
    } 
}