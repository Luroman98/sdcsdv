package ru.kata.spring.boot_security.demo.web.dao;


import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getRole(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> listAllRole() {
        return entityManager.createQuery("select w from Role w", Role.class).getResultList();
    }

}
