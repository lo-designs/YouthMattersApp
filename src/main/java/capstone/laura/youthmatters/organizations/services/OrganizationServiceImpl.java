package capstone.laura.youthmatters.organizations.services;

import capstone.laura.youthmatters.organizations.models.Organization;
import capstone.laura.youthmatters.organizations.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public List<Organization> getAllOrganizationLists() {
        return organizationRepository.findAll();
    }

    @Override
    public void saveOrganization(Organization organization) {
        organizationRepository.save(organization);

    }

    @Override
    public Organization getOrganizationById(long id) {
        Optional<Organization> optional = organizationRepository.findById(id);
        Organization organization = null;
        if (optional.isPresent()) {
            organization = optional.get();
        } else {
            throw new RuntimeException("organization not found for id :: " + id);
        }
        return organization;
    }

    @Override
    public void deleteOrganizationById(long id) {
        organizationRepository.deleteById(id);
    }
}
