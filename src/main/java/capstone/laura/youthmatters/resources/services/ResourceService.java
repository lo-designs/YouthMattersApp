package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.Resource;

import java.util.List;

public interface ResourceService {

    List<Resource> getAllResourceLists();

    List<Resource> getResourceListByEmail(String email);

    void saveResource(Resource resource);
    Resource getResourceById(long id);
    void deleteResourceById(long id);
}
