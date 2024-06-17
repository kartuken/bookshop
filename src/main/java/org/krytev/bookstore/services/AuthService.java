package org.krytev.bookstore.services;

import lombok.RequiredArgsConstructor;
import org.krytev.bookstore.domain.RoleEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.repositories.RoleRepository;
import org.krytev.bookstore.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public void registration(UserEntity user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RoleEntity userRole = roleRepository.findById(1L).get();
        user.setRoles(List.of(userRole));
        userRepository.save(user);
    }
}
