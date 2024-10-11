package com.bookSpring.bookSpring.config.auth.dto;

import com.bookSpring.bookSpring.domain.user.*;
import lombok.*;

import java.io.*;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
