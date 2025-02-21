package xyz.owlie.acme.controllers.auth;

import io.quarkus.security.Authenticated;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import jakarta.inject.Inject;
import xyz.owlie.acme.controllers.auth.dto.AuthUserConnectDto;
import xyz.owlie.acme.services.AuthService;


@Path("auth")
public class AuthController {
    private final AuthService authService;

    @Inject
    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @POST
    @Authenticated
    @Path("connect")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response connect(AuthUserConnectDto connect){
        try {
            String token = this.authService.login(connect.username(), connect.password());
            return Response.ok(token).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }


}
