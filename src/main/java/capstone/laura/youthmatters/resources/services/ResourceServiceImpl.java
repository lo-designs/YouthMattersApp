package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.Resource;
import capstone.laura.youthmatters.resources.models.ResourceTag;
import capstone.laura.youthmatters.resources.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceService resourceService;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository, ResourceService resourceService) {
        this.resourceRepository = resourceRepository;
        this.resourceService = resourceService;
    }

    @Override
    public List<Resource> getAllResourceLists() {
        return resourceRepository.findAll();
    }

    @Override
    public List<Resource> getResourcesByTags(Collection<Long> ids) {
        return resourceRepository.findResourcesByTagIds(ids);
    }

    @Override
    public void saveResource(Resource resource) {
        resourceRepository.save(resource);

    }
    @Override
    public List<Resource> getResourceListByEmail(String email) {
        return resourceService.getResourceListByEmail(email);
    }
    @Override
    public Resource getResourceById(long id) {
        Optional<Resource> optional = resourceRepository.findById(id);
        Resource resource = null;
        if (optional.isPresent()) {
            resource = optional.get();
        } else {
            throw new RuntimeException("resource not found for id :: " + id);
        }
        return resource;
    }

    @Override
    public void deleteResourceById(long id) {
        resourceRepository.deleteById(id);
    }
}
