package ru.gb.lesson12.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson12.entity.security.AccountRole;

public interface AccountRoleDao extends JpaRepository<AccountRole, Long> {

}
