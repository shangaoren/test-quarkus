package xyz.owlie.acme.controllers.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthUserConnectDto(
        @JsonProperty(required = true) String username,
        @JsonProperty(required = true) String password
){}
