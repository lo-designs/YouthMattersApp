package capstone.laura.youthmatters.organizations.services;

import capstone.laura.youthmatters.organizations.models.OrgTag;
import capstone.laura.youthmatters.organizations.repositories.OrgTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgTagServiceImpl implements OrgTagService {

    private OrgTagRepository orgTagRepository;

    @Autowired
    public OrgTagServiceImpl(OrgTagRepository orgTagRepository) {
        this.orgTagRepository = orgTagRepository;
    }

    @Override
    public List<OrgTag> getAllTagsFromCategory(String category) {
        return orgTagRepository.findByCategory(category);
    }
}
