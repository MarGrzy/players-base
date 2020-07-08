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
import pl.mg.projects.players.secuirty.AuthorityHolder;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthorityHolder authorityHolder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthorityHolder authorityHolder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authorityHolder = authorityHolder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.getByUsername(username);
        if (byUsername.isEmpty()) {
            throw new UsernameNotFoundException(username);
        } else {
            User user = byUsername.get();
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityHolder.addUserRole());
        }
    }

    public boolean createUser(AuthorizationDto authorizationDto) {
        String username = authorizationDto.getUsername();
        if (userRepository.getByUsername(username).isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(bCryptPasswordEncoder.encode(authorizationDto.getPassword()));
            userRepository.save(user);
            return true;
        } else return false;
    }

    public Optional<User> getByUsername(String newUsername) { return userRepository.getByUsername(newUsername); }
}
