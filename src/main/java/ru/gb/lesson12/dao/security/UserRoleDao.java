package ru.gb.lesson12.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson12.entity.security.UserRole;

public interface UserRoleDao extends JpaRepository<UserRole, Long> {

}
