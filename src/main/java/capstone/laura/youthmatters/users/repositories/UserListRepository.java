package capstone.laura.youthmatters.users.repositories;

import capstone.laura.youthmatters.users.models.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepository extends JpaRepository<UserList, Long> {
}
