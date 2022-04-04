package org.multicampus.mlp.domain.entity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
@NoArgsConstructor
@ToString
@Table(name = "USER_T")
@Entity
public class User implements UserDetails {
    @Id
    @Column(name = "USER_ID", length = 256, nullable = false)
    private String userId;

    @Column(name = "USER_PW", length = 256)
    private String userPw;

    @Column(name = "USER_BIRTHDATE")
    private LocalDate userBirthDate;

    @Column(name = "USER_NAME", length = 256, nullable = false)
    private String userName;

    @Column(name = "USER_ACTIVE", length = 1)
    private String userActive;

    @Column(name = "USER_ADMIN", length = 1)
    private String userAdmin;

    @Column(name = "USER_HOST", length = 1)
    private String userHost;

    @Column(name = "USER_CHECK", length = 1)
    private String userCheck;

    @Column(name = "USER_CREATE", nullable = false)
    private LocalDateTime userCreate;

    @Column(name = "USER_UPDATE")
    private LocalDateTime userUpdate;

    @Column(name = "USER_PHONE", length = 256)
    private String userPhone;

    @Column(name = "USER_EMAIL", length = 256, nullable = false)
    private String userEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Builder
    public User(
            String userId,
            String userPw,
            String userName,
            String userPhone,
            String userAdmin,
            String userActive,
            String userHost,
            String userCheck,
            String userEmail,
            Role role,
            LocalDateTime userCreate,
            LocalDateTime userUpdate

    ){
        this.userId = userId;
        this.userPw = userPw;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userAdmin = userAdmin;
        this.userActive = userActive;
        this.userHost = userHost;
        this.userCheck = userCheck;
        this.userEmail = userEmail;
        this.role = role;
        this.userCreate = userCreate;
        this.userUpdate = userUpdate;
    }

    public User update(String userName){
        this.userName = userName;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
