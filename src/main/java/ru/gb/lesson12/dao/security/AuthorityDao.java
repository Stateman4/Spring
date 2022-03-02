package ru.gb.lesson12.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson12.entity.security.Authority;

public interface AuthorityDao extends JpaRepository<Authority, Long> {

}
