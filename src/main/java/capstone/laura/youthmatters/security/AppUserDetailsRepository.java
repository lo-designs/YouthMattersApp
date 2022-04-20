package capstone.laura.youthmatters.security;

import capstone.laura.youthmatters.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserDetailsRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserById(Long Id);
    AppUser findByEmail(String email);
}
