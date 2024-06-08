package org.krytev.bookstore;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.krytev.bookstore.domain.RoleEntity;
import org.krytev.bookstore.domain.UserEntity;
import org.krytev.bookstore.dtos.UserRegDto;
import org.krytev.bookstore.repositories.RoleRepository;
import org.krytev.bookstore.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegController {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/auth/registration")
    public String registration(@RequestBody UserRegDto dto){
        UserEntity user = new UserEntity();
        user.setEmail(dto.getEmail());
        user.setFio(dto.getFio());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        RoleEntity role = new RoleEntity("ROLE_USER");
        roleRepository.save(role);

        user.setRoles(List.of(role));
        userRepository.save(user);
        return user.toString();
    }

}
