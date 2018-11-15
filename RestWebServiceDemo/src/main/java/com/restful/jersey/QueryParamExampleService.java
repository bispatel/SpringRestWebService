package com.restful.jersey;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/employee")
public class QueryParamExampleService {
 
    @GET
    @Path("/query")
    public Response getEmployeeQuery(@QueryParam("dept") String department,
                                    @QueryParam("branch") String branch){
        String resp = "Query parameters are received. 'dept' value is: "
                        +department+" and branch value is: "+branch;
         
        return Response.status(200).entity(resp).build();
    }
    
    @GET
    @Path("/bulkParam")
    public Response getEmployeeQuery(@Context UriInfo uriInfo){
         
        /** read complete employee id list from request query parameter**/
        List<String> empIdList = uriInfo.getQueryParameters().get("id");
        System.out.println("Received List: "+empIdList);
        /** read first employee id from request query parameter **/
        String firstEmpId = uriInfo.getQueryParameters().getFirst("id");
        System.out.println("First emp record from the request: "+firstEmpId);
         
        return Response.status(200).entity("processed request").build();
    }
}