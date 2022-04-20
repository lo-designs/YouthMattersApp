package capstone.laura.youthmatters.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserById(Long id);
    AppUser findByEmail(String email);


}
