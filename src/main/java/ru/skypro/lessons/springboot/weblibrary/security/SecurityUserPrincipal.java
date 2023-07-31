package ru.skypro.lessons.springboot.weblibrary.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.skypro.lessons.springboot.weblibrary.dto.AuthUserDTO;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SecurityUserPrincipal implements UserDetails {
    private final AuthUserDTO authUserDTO;
    public SecurityUserPrincipal(AuthUserDTO authUserDTO) {
        this.authUserDTO = authUserDTO;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Optional.ofNullable(authUserDTO)
                .map(AuthUserDTO::getRole)
                .map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .map(List::of)
                .orElse(Collections.emptyList());
    }
    @Override
    public boolean isEnabled() {
        if (authUserDTO.getEnabled() == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String getPassword() {
        return authUserDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return authUserDTO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


}
