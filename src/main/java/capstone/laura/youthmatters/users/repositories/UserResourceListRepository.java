package capstone.laura.youthmatters.users.repositories;

import capstone.laura.youthmatters.users.models.UserResourceList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResourceListRepository extends JpaRepository<UserResourceList, Long> {
}
