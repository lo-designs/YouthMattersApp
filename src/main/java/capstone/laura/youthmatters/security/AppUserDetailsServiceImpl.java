package capstone.laura.youthmatters.security;

import capstone.laura.youthmatters.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AppUserDetailsServiceImpl implements AppUserDetailsService {

    private final AppUserDetailsRepository appUserDetailsRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AppUserDetailsServiceImpl(AppUserDetailsRepository appUserDetailsRepository, BCryptPasswordEncoder passwordEncoder) {
        this.appUserDetailsRepository = appUserDetailsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUser save(AppUserDto registration) {
        AppUser user = new AppUser();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setAge(registration.getAge());
        user.setZipcode((int) registration.getZipcode());
        System.out.println(registration.getPassword());
        System.out.println(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return appUserDetailsRepository.save(user);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = appUserDetailsRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}

