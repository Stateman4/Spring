package ru.gb.lesson12.entity.security;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "user_role", schema="public")
public class UserRole {

    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Builder.Default
    @Column(name = "ROLE_ID")
    private Long roleId = 2L;

}
