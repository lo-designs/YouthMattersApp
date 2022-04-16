package capstone.laura.youthmatters.resources.repositories;

import capstone.laura.youthmatters.resources.models.Hotline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotlineRepository extends JpaRepository<Hotline, Long> {
}
