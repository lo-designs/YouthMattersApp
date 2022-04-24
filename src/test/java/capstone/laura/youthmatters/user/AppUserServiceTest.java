package capstone.laura.youthmatters.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppUserServiceTest {

    @Autowired
    private AppUserService appUserService;

    @Test
    void getUserById() {
        AppUser appUser = appUserService.getUserById(1L);
        Assertions.assertThat(appUser.getId()).isEqualTo(1L);
    }

    @Test
    void findUserByEmail() {
        AppUser appUser = appUserService.findUserByEmail("liz@gmail.com");
        Assertions.assertThat(appUser.getEmail()).isEqualTo("liz@gmail.com");
    }
}