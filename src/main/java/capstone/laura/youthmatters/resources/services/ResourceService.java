package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.Resource;
import capstone.laura.youthmatters.resources.models.ResourceTag;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ResourceService {

    List<Resource> getAllResources();

    List<Resource> getResourcesByTags(Collection<Long> ids);


    void saveResource(Resource resource);

    List<Resource> getResourceByEmail(String email);

    Resource getResourceById(long id);
    void deleteResourceById(long id);
}
