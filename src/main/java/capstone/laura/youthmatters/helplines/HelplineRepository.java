package capstone.laura.youthmatters.helplines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelplineRepository extends JpaRepository<Helpline, Long> {

    Helpline findHelplineById(Long id);

}
