package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.Resource;

import java.util.List;

public interface ResourceService {

    List<Resource> getAllOrganizationLists();
    void saveOrganization(Resource resource);
    Resource getOrganizationById(long id);
    void deleteOrganizationById(long id);
}
