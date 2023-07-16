package ru.skypro.lessons.springboot.weblibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.weblibrary.dto.AuthUserDTO;
import ru.skypro.lessons.springboot.weblibrary.repository.UserRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserDTO userDTO = AuthUserDTO.fromAuthUser(userRepository.findByUsername(username));
        if (userDTO == null) {
            throw new UsernameNotFoundException(username);
        }

        return new SecurityUserPrincipal(userDTO);
    }
}
