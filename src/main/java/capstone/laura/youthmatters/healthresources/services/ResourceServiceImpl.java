package capstone.laura.youthmatters.healthresources.services;

import capstone.laura.youthmatters.healthresources.models.Resource;
import capstone.laura.youthmatters.healthresources.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {


    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> getAllResources() {
        return null;
    }

    @Override
    public List<Resource> getResourcesByTags(Collection<Long> ids) {
        return resourceRepository.findResourcesByTagIds(ids);
    }

    @Override
    public void saveResource(Resource resource) {

    }

    @Override
    public List<Resource> getResourceByEmail(String email) {
        return null;
    }

    @Override
    public Resource getResourceById(long id) {
        return null;
    }

    @Override
    public void deleteResourceById(long id) {

    }
}