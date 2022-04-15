package capstone.laura.youthmatters.resources.repositories;

import capstone.laura.youthmatters.resources.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
