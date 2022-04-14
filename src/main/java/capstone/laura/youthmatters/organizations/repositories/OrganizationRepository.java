package capstone.laura.youthmatters.organizations.repositories;

import capstone.laura.youthmatters.organizations.models.OrgTag;
import capstone.laura.youthmatters.organizations.models.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
