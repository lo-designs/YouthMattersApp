package capstone.laura.youthmatters.user;

import java.util.List;

public interface AppUserService {

    void saveAppUser(AppUser appUser);
    AppUser getUserById(long id);
    AppUser findUserByEmail(String email);



}