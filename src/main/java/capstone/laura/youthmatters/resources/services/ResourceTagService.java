package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.ResourceTag;

import java.util.List;

public interface ResourceTagService {

    List<ResourceTag> getAllTagsFromCategory(String category);

}
