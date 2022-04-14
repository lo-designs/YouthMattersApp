package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.users.models.ResourceList;

import java.util.List;

public interface ResourceListService {

    List<ResourceList> getAllResourceLists();
    void saveResourceList(ResourceList resourceList);
    ResourceList getResourceListById(long id);
    void deleteResourceListById(long id);
}
