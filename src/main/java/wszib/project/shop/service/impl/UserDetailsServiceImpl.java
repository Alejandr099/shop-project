package wszib.project.shop.service.impl;

import wszib.project.shop.domain.User;
import wszib.project.shop.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.findByUsername(username);

        if (user != null) {
            Set<GrantedAuthority> authorities = new HashSet<>();
            if (Objects.equals(username, "admin")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }else {
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            }
            logger.debug(String.format("Użytkownik o nazwie: %s i podanym haśle: %s został stworzony.", user.getUsername(), user.getPassword()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }else{
            throw new UsernameNotFoundException("Użytkownik o nazwie " + username + " nie został znaleziony");
        }
    }


}
