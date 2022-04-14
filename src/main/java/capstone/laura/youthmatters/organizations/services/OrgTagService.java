package capstone.laura.youthmatters.organizations.services;

import capstone.laura.youthmatters.organizations.models.OrgTag;

import java.util.List;

public interface OrgTagService {

    List<OrgTag> getAllTagsFromCategory(String category);

}
