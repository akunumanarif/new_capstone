package com.ikon.authservice.service.impl;

import com.ikon.authservice.dto.UserDTO;
import com.ikon.authservice.entity.User;
import com.ikon.authservice.entity.UserSecurity;
import com.ikon.authservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JpaUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            return new UserSecurity(user.get());
        }
        throw new UsernameNotFoundException("username not found");
    }

    public List<UserDTO> getAll() {

        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for(User user : users) {
            userDTOList.add(modelMapper.map(user, UserDTO.class));
        }

        return userDTOList;
    }


}


