package capstone.laura.youthmatters.organizations.repositories;

import capstone.laura.youthmatters.organizations.models.OrgTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgTagRepository extends JpaRepository<OrgTag, Long> {

    List<OrgTag> findByCategory(String category);

}
