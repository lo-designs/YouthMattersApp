package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.security.AppUser;

public interface AppUserService {

    void saveAppUser(AppUser appUser);
    AppUser getUserById(long id);

}