package xyz.owlie.acme.controllers;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import xyz.owlie.acme.services.UserService;
import xyz.owlie.acme.types.UserCreation;
import xyz.owlie.acme.entities.User;

@Path("users")
public class UserController {
    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(UserCreation user){
        return userService.createUser(user.username(), user.email(), user.password());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getUser(Long id){
        return userService.getFromId(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User[] getAllUsers(){
        return userService.getAll();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUser(String id){
        return "update user with id: " + id;
    }
}
