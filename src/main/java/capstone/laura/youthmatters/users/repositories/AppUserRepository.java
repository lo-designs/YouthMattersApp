package capstone.laura.youthmatters.users.repositories;

import capstone.laura.youthmatters.users.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserById(Long id);
    AppUser findByEmail(String email);


}
