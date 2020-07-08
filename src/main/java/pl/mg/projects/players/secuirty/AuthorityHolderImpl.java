package pl.mg.projects.players.secuirty;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Component
public class AuthorityHolderImpl implements AuthorityHolder {

    @Override
    public Set<SimpleGrantedAuthority> addUserRole() {
       return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Set<SimpleGrantedAuthority> addAdminRole() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
