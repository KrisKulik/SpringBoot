package ru.skypro.lessons.springboot.weblibrary.dto;

import ru.skypro.lessons.springboot.weblibrary.pojo.AuthUser;
import ru.skypro.lessons.springboot.weblibrary.pojo.Role;

public class AuthUserDTO {
        private Long id;
        private int enabled;
        private String username;
        private String password;
        private Role role;
    public static AuthUserDTO fromAuthUser(AuthUser authUser) {
        AuthUserDTO authUserDTO = new AuthUserDTO();
        authUserDTO.setId(authUser.getId());
        authUserDTO.setEnabled(authUser.getEnabled());
        authUserDTO.setUsername(authUser.getUsername());
        authUserDTO.setPassword(authUser.getPassword());
        authUserDTO.setRole(authUser.getRole());
        return authUserDTO;
    }

    public AuthUser toAuthUser() {
        AuthUser authUser = new AuthUser();
        authUser.setId(this.getId());
        authUser.setEnabled(this.getEnabled());
        authUser.setUsername(this.getUsername());
        authUser.setPassword(this.getPassword());
        authUser.setRole(this.getRole());
        return authUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    }

