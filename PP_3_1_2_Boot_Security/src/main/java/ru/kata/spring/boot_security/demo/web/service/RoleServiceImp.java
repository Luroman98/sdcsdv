package ru.kata.spring.boot_security.demo.web.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.web.dao.RoleDao;
import ru.kata.spring.boot_security.demo.web.model.Role;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImp implements RoleService {

    private  RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
        saveRole(new Role(1L, "ROLE_ADMIN"));
        saveRole(new Role(2L, "ROLE_USER"));
    }
    @Transactional
    @Override
    public void saveRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public Set<Role> getRole(List<Long> id) {
        Set<Role> roles = new HashSet<>();
        id.forEach(x -> roles.add(roleDao.getRole(x)));
        return roles;
    }

    @Override
    public List<Role> listAll() {
        return roleDao.listAllRole();
    }
}