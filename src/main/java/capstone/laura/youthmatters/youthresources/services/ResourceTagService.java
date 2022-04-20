package capstone.laura.youthmatters.youthresources.services;

import capstone.laura.youthmatters.youthresources.models.ResourceTag;

import java.util.List;

public interface ResourceTagService {

    List<ResourceTag> getAllTagsFromCategory(String category);
    List<ResourceTag> getAllTagWithIds(List<Long> idsList);
}
