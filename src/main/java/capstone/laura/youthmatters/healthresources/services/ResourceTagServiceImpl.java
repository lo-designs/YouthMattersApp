package capstone.laura.youthmatters.healthresources.services;

import capstone.laura.youthmatters.healthresources.models.ResourceTag;
import capstone.laura.youthmatters.healthresources.repositories.ResourceTagRepository;
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

    @Override
    public List<ResourceTag> getAllTagWithIds(List<Long> idsList) {
        return resourceTagRepository.findAllById(idsList);
    }
}
