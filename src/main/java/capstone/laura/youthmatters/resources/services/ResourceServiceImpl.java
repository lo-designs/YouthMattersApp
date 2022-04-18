package capstone.laura.youthmatters.resources.services;

import capstone.laura.youthmatters.resources.models.Resource;
import capstone.laura.youthmatters.resources.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Override
    public List<Resource> getAllResources() {
        return null;
    }

    @Override
    public List<Resource> getResourcesByTags(Collection<Long> ids) {
        return null;
    }

    @Override
    public void saveResource(Resource resource) {

    }

    @Override
    public List<Resource> getResourceByEmail(String email) {
        return null;
    }

    @Override
    public Resource getResourceById(long id) {
        return null;
    }

    @Override
    public void deleteResourceById(long id) {

    }
}