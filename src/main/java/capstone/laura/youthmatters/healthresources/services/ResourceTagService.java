package capstone.laura.youthmatters.healthresources.services;

import capstone.laura.youthmatters.healthresources.models.ResourceTag;

import java.util.List;

public interface ResourceTagService {

    List<ResourceTag> getAllTagsFromCategory(String category);
    List<ResourceTag> getAllTagWithIds(List<Long> idsList);
}
