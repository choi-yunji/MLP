package org.multicampus.mlp.config.dto;

import lombok.Getter;
import org.multicampus.mlp.domain.entity.user.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String userName;
    private String userEmail;

    public SessionUser(User user) {
        this.userName = user.getUsername();
        this.userEmail = user.getUserEmail();
    }

}
