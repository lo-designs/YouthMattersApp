package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.ResourceTag;
import capstone.laura.youthmatters.resources.repositories.ResourceTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceTagServiceImpl implements ResourceTagService {

    private ResourceTagRepository resourceTagRepository;

    @Autowired
    public ResourceTagServiceImpl(ResourceTagRepository resourceTagRepository) {
        this.resourceTagRepository = resourceTagRepository;
    }

    @Override
    public List<ResourceTag> getAllTagsFromCategory(String category) {
        return resourceTagRepository.findByCategory(category);
    }
}
