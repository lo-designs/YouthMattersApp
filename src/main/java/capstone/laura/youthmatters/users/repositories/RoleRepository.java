package capstone.laura.youthmatters.users.repositories;

import capstone.laura.youthmatters.users.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
