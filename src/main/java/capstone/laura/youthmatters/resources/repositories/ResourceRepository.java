package capstone.laura.youthmatters.resources.repositories;

import capstone.laura.youthmatters.resources.models.Resource;
import capstone.laura.youthmatters.resources.models.ResourceTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

//    Set<Resource> findByResourceTagsIn(Collection<Set<ResourceTag>> resourceTags);
    @Query("select r from Resource r join r.resourceTags t where t.id in ?1")
    List<Resource> findResourcesByTagIds(Collection<Long> ids);

}
