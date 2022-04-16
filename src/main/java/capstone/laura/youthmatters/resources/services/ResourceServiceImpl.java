package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.Resource;
import capstone.laura.youthmatters.resources.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public List<Resource> getAllResourceLists() {
        return resourceRepository.findAll();
    }

    @Override
    public void saveResource(Resource resource) {
        resourceRepository.save(resource);

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
