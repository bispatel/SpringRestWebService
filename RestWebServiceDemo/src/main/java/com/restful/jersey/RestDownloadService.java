package com.restful.jersey;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/download")
public class RestDownloadService {
 
    @GET
    @Path("/service-record")
    @Produces("application/pdf")
    public Response getFile() {
  
        String fileName = "temp\\Test.pdf";
        ClassLoader classLoader = this.getClass().getClassLoader();
 
        File file = new File(classLoader.getResource(fileName).getFile());
        ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition",
            "attachment; filename=\"Test.pdf\"");
        return response.build();
    }
}