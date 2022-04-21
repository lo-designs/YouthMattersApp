package capstone.laura.youthmatters.youth.resources.services;

import capstone.laura.youthmatters.youth.resources.models.ResourceTag;
import capstone.laura.youthmatters.youth.resources.repositories.ResourceTagRepository;
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
