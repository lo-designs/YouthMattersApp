package capstone.laura.youthmatters.youthresources.repositories;

import capstone.laura.youthmatters.youthresources.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Resource findResourceById(String id);
//    Set<Resource> findByResourceTagsIn(Collection<Set<ResourceTag>> resourceTags);
    @Query("select r from Resource r join r.resourceTags t where t.id in ?1")
    List<Resource> findResourcesByTagIds(Collection<Long> ids);

}
