package capstone.laura.youthmatters.resources.repositories;

import capstone.laura.youthmatters.resources.models.ResourceTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceTagRepository extends JpaRepository<ResourceTag, Long> {

    List<ResourceTag> findByCategory(String category);

}
