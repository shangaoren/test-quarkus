package xyz.owlie.acme.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import xyz.owlie.acme.entities.User;

@ApplicationScoped
public class UserRepository {
    private final EntityManager em;

    @Inject
    public UserRepository(EntityManager em){
        this.em = em;
    }

    public User save(User user){
        em.persist(user);
        return user;
    }

    public User findById(Long id){
        return em.find(User.class, id);
    }

    public User[] findMany(){
        return em.createQuery("SELECT u FROM User u", User.class).getResultList().toArray(User[]::new);
    }

    public User findByUsername(String username){
        try {
            return em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
                    .setParameter("username", username).getSingleResult();
        } catch (Exception e){
            return null;
        }
    }
}
