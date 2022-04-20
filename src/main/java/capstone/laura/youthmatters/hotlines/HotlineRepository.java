package capstone.laura.youthmatters.hotlines;

import capstone.laura.youthmatters.hotlines.Hotline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotlineRepository extends JpaRepository<Hotline, Long> {
}
