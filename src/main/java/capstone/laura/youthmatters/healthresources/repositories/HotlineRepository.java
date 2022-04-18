package capstone.laura.youthmatters.healthresources.repositories;

import capstone.laura.youthmatters.healthresources.models.Hotline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotlineRepository extends JpaRepository<Hotline, Long> {
}
