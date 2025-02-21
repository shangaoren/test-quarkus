package xyz.owlie.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import xyz.owlie.acme.repository.UserRepository;
import xyz.owlie.acme.entities.User;
import xyz.owlie.acme.util.Password;

@ApplicationScoped
public class UserService {
    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(String name, String email, String password){
        String hashedPassword = Password.hash(password);
        return userRepository.save(new User(name, hashedPassword, email));
    }

    public User getFromId(Long id){
        try {
            return this.userRepository.findById(id);
        } catch (Exception e){
            return null;
        }
    }

    @Transactional
    public User[] getAll(){
        return this.userRepository.findMany();
    }
}
