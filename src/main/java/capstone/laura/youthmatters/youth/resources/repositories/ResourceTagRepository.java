package capstone.laura.youthmatters.youth.resources.repositories;

import capstone.laura.youthmatters.youth.resources.models.ResourceTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceTagRepository extends JpaRepository<ResourceTag, Long> {

    List<ResourceTag> findByCategory(String category);

}
