package ru.gb.lesson12.entity.security;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITY", schema="public")
public class Authority implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "permission")
    private String permission;

    @ManyToMany(mappedBy = "authorities")
    private Set<AccountRole> roles;

    @Override
    public String getAuthority() {
        return this.permission;
    }
}
