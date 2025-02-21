package xyz.owlie.acme.controllers;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/hello")
public class GreetingsController {
    @Inject
    JsonWebToken jwt;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello my test appli";
    }

    @GET
    @Authenticated
    @Path("token")
    public String test(){
        return jwt.getClaim("email");
    }

    @RolesAllowed("User")
    @Path("time")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String time(){
        return java.time.LocalDateTime.now().toString();
    }
}
