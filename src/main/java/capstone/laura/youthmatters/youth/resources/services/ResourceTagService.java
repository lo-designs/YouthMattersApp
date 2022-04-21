package capstone.laura.youthmatters.youth.resources.services;

import capstone.laura.youthmatters.youth.resources.models.ResourceTag;

import java.util.List;

public interface ResourceTagService {

    List<ResourceTag> getAllTagsFromCategory(String category);
    List<ResourceTag> getAllTagWithIds(List<Long> idsList);
}
