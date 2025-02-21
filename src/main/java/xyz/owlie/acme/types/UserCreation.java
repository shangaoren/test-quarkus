package xyz.owlie.acme.types;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserCreation(
        @JsonProperty("username") String username,
        @JsonProperty("email") String email,
        @JsonProperty("password") String password) {}