package ru.gb.lesson12.entity.security;

import lombok.*;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Entity
@Table(name = "ACCOUNT_USER", schema="public")
public class AccountUser implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    @Singular
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    private Set<AccountRole> roles;

    @Transient
    private Set<Authority> authorities;

    @Builder.Default
    @Column(name = "account_non_expired")
    private boolean AccountNonExpired = true;

    @Builder.Default
    @Column(name = "account_non_locked")
    private boolean AccountNonLocked = true;

    @Builder.Default
    @Column(name = "credentials_non_expired")
    private boolean CredentialsNonExpired = true;

    @Builder.Default
    @Column(name = "enabled")
    private boolean enabled = true;

    //получаем список ролей
    public Set<GrantedAuthority> getAuthorities(){
        Set<GrantedAuthority> authorities = this.roles.stream()
                .map(AccountRole::getAuthorities)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
        authorities.addAll(mapRolesToAuthorities(this.roles));
        return authorities;
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<AccountRole> roles){
     return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public AccountUser(){
        this.AccountNonExpired = true;
        this.AccountNonLocked = true;
        this.CredentialsNonExpired = true;
        this.enabled = true;
    }
}
