package capstone.laura.youthmatters.youth.resources.repositories;

import capstone.laura.youthmatters.youth.resources.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Resource findResourceById(String id);
    @Query("SELECT r FROM Resource r JOIN r.resourceTags t WHERE t.id in ?1")
    List<Resource> findResourcesByTagIds(Collection<Long> ids);

    Resource getResourceByName(String name);
    @Query(nativeQuery = true, value = "SELECT * FROM Resource r ORDER BY r.name")
    List<Resource> findResourceByName(Collection<Long> name);

}
