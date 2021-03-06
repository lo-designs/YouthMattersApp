package capstone.laura.youthmatters.user;

import capstone.laura.youthmatters.youth.resources.models.Resource;

public interface AppUserService {

    void saveAppUser(AppUser appUser);
    AppUser getUserById(long id);
    AppUser findUserByEmail(String email);

    void saveResourceToUser(Resource resource, long id);

}