package capstone.laura.youthmatters.youthresources.services;

import capstone.laura.youthmatters.youthresources.models.Resource;
import capstone.laura.youthmatters.youthresources.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    @Override
    public void saveResource(Resource resource) {
        resourceRepository.save(resource);
    }

    @Override
    public List<Resource> getResourceByEmail(String email) {
        return null;
    }

    @Override
    public Resource getResourceById(long id) {
        Optional<Resource> optionalResource = resourceRepository.findById(id);
        if (optionalResource.isPresent()) {
            return optionalResource.get();
        }
        throw new ResourceNotFoundException();
    }

    @Override
    public Resource findById(String name) {
        return null;
    }

    @Override
    public void deleteResourceById(long id) {
        resourceRepository.deleteById(id);
    }


//***  GET RESOURCES BY RESOURCE TAGS ***//

    @Override
    public List<Resource> getResourcesByTags(Collection<Long> ids) {
        return resourceRepository.findResourcesByTagIds(ids);
    }

}