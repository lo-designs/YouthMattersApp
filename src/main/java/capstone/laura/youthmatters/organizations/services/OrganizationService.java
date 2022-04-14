package capstone.laura.youthmatters.organizations.services;

import capstone.laura.youthmatters.organizations.models.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> getAllOrganizationLists();
    void saveOrganization(Organization organization);
    Organization getOrganizationById(long id);
    void deleteOrganizationById(long id);
}
