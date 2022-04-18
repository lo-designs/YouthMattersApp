package capstone.laura.youthmatters.healthresources.services;

import capstone.laura.youthmatters.healthresources.models.Resource;

import java.util.Collection;
import java.util.List;

public interface ResourceService {

    List<Resource> getAllResources();

    List<Resource> getResourcesByTags(Collection<Long> ids);


    void saveResource(Resource resource);

    List<Resource> getResourceByEmail(String email);

    Resource getResourceById(long id);
    void deleteResourceById(long id);
}
