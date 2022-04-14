package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.users.models.ResourceList;
import capstone.laura.youthmatters.users.repositories.ResourceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceListServiceImpl implements ResourceListService {

    @Autowired
    private ResourceListRepository resourceListRepository;

    @Override
    public List<ResourceList> getAllResourceLists() {
        return resourceListRepository.findAll();
    }

    @Override
    public void saveResourceList(ResourceList resourceList) {
        this.resourceListRepository.save(resourceList);
    }

    @Override
    public ResourceList getResourceListById(long id) {
        Optional<ResourceList> optional = resourceListRepository.findById(id);
        ResourceList resourceList = null;
        if (optional.isPresent()) {
            resourceList = optional.get();
        } else {
            throw new RuntimeException("not found for id:: " + id);
        }
        return resourceList;
    }

    @Override
    public void deleteResourceListById(long id) {
        this.resourceListRepository.deleteById(id);
    }
}
