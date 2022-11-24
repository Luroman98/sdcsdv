package ru.kata.spring.boot_security.demo.web.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }

    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
    public List<User> listUsers() {
        return entityManager.createQuery("select w from User w", User.class).getResultList();
    }
    public void update(Long id, User updateUser) {
        User userToBeUpdated = getUser(id);
        userToBeUpdated.setFirstName(updateUser.getFirstName());
        userToBeUpdated.setLastName(updateUser.getLastName());
        userToBeUpdated.setEmail(updateUser.getEmail());

    }
    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }
    public User getUserByUserName(String name) {
        return entityManager.find(User.class, name);
    }
}
