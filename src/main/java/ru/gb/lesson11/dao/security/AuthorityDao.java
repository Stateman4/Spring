package ru.gb.lesson11.dao.security;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.lesson11.entity.security.Authority;

public interface AuthorityDao extends JpaRepository<Authority, Long> {

}
