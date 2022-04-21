//package capstone.laura.youthmatters.services;
//
//import capstone.laura.youthmatters.user.AppUser;
//import capstone.laura.youthmatters.user.AppUserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) class AppUserServiceImplTest {
//
//    @Autowired
//    private AppUserService appUserService;
//
//    @Test
//    void getAllAppUsers() {
//        List<AppUser> allAppUsers = AppUserService.getAllAppUsers();
//        int beforeAddingMoreAppUsers = allAppUsers.size();
//
//        AppUser appUser1 = new AppUser();
//        appUser1.setLastName("Hicks");
//        appUser1.setFirstName("Bill");
//        appUser1.setEmail("bill.hicks@aol.com");
//        int afterAddingMoreAppUsers = AppUserService.getAllAppUsers().size();
//
//        Assertions.assertThat(afterAddingMoreAppUsers).isEqualTo(beforeAddingMoreAppUsers + 1);
//        Assertions.assertThat(allAppUsers.contains(appUser1));
//    }
//
//        @Test
//        void getAppUserById() {
//            List<AppUser> allAppUsers = AppUserService.getAllAppUsers();
//            AppUser appUser1 = allAppUsers.get(0);
//            if (appUser1 != null) {
//                AppUser appUser2 = appUserService.getUserById(1);
//                Assertions.assertThat(appUser1).isEqualTo(appUser2);
//            }
//        }
//
//}
