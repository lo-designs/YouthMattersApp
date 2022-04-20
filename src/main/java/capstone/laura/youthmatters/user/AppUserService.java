package capstone.laura.youthmatters.user;

public interface AppUserService {

    void saveAppUser(AppUser appUser);
    AppUser getUserById(long id);
    AppUser findUserByEmail(String email);
}