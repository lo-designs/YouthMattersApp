package capstone.laura.youthmatters.youth.resources.repositories;

import capstone.laura.youthmatters.youth.resources.models.Resource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class ResourceRepositoryTest {

    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    void findResourceById() {
        Resource resource = resourceRepository.getById(21L);
        Assertions.assertThat(resource.getId()).isEqualTo(21L);
    }

    @Test
    void getResourceByName() {
        Resource resource = resourceRepository.getResourceByName("The Emily Program");
        Assertions.assertThat(resource.getName()).isEqualTo("The Emily Program");
    }


}