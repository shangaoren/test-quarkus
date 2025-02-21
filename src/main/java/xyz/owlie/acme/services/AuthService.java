package xyz.owlie.acme.services;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import xyz.owlie.acme.entities.User;
import xyz.owlie.acme.repository.UserRepository;
import xyz.owlie.acme.util.Password;

import java.time.Instant;
import java.util.Set;

@ApplicationScoped
public class AuthService {
    private final UserRepository userRepository;

    @Inject
    AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String login(String username, String password) throws Exception {
        User user = userRepository.findByUsername(username);
        if(user == null || !Password.verify(password, user.getPassword())) {
            throw new Exception("username password pair does not exists");
        }
        return this.createTokenFromUser(user);
    }

    private String createTokenFromUser(User user){
        return Jwt
                .issuer("https://owlie.xyz")
                .upn(user.getEmail())
                .groups(Set.of("User"))
                .claim("username", user.getUsername())
                .claim("email", user.getEmail())
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(3600))
                .sign();
    }
}
