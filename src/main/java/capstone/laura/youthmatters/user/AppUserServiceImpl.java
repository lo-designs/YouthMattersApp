package capstone.laura.youthmatters.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        this.appUserRepository.save(appUser);
    }

    @Override
    public AppUser getUserById(long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return appUserRepository.findUserByEmail(email);
    }

}
