package org.multicampus.mlp.config.dto;

import lombok.Builder;
import lombok.Getter;
import org.multicampus.mlp.domain.entity.user.Role;
import org.multicampus.mlp.domain.entity.user.User;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String userName;
    private String userEmail;


    @Builder
    public  OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String userName, String userEmail){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        return OAuthAttributes.builder()
                .userName((String) attributes.get("name"))
                .userEmail((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .userId(userEmail)
                .userName(userName)
                .userEmail(userEmail)
                .role(Role.GUEST)
                .userActive("N")
                .userHost("N")
                .userCheck("N")
                .userAdmin("N")
                .userCreate(LocalDateTime.now())
                .userUpdate(LocalDateTime.now())
                .build();


    }

}
