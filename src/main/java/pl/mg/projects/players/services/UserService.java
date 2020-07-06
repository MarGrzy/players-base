package pl.mg.projects.players.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mg.projects.players.dto.AuthorizationDto;
import pl.mg.projects.players.repositories.UserRepository;
import pl.mg.projects.players.entities.User;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> byUserName = userRepository.getByUserName(userName);
        if (byUserName.isEmpty()) {
            throw new UsernameNotFoundException(userName);
        } else {
            User user = byUserName.get();
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), Collections.emptyList());
        }
    }

    public boolean createUser(AuthorizationDto authorizationDto) {
        String userName = authorizationDto.getUserName();
        if (userRepository.getByUserName(userName).isEmpty()) {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(bCryptPasswordEncoder.encode(authorizationDto.getPassword()));
            userRepository.save(user);
            return true;
        } else return false;
    }

    public Optional<User> getByUsername(String newUsername) { return userRepository.getByUserName(newUsername); }
}
