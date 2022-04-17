package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.users.models.AppUser;
import capstone.laura.youthmatters.users.repositories.AppUserRepository;
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
}
