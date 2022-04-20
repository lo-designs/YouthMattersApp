package capstone.laura.youthmatters.hotlines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotlineRepository extends JpaRepository<Hotline, Long> {

    Hotline findHotlineById(Long id);

}
