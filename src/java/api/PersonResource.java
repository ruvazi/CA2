/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import control.ControlCRUD;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Emil
 */
@Path("generic")
public class PersonResource {
    Gson gson;

    @Context
    private UriInfo context;

    public PersonResource() {
        gson = new GsonBuilder()
            .setPrettyPrinting()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create();
}

    @GET
    @Path("{phoneNumber}")
    @Produces("application/json")
    public Response getPerson(@PathParam("phoneNumber") String phoneNumber) {
        System.out.println(phoneNumber);
        return Response.status(Response.Status.OK).entity(gson.toJson(ControlCRUD.getPerson(phoneNumber))).build();
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
