package capstone.laura.youthmatters.security;


import capstone.laura.youthmatters.user.AppUser;

public interface AppUserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    AppUser save(AppUserDto appUserDto);
}
