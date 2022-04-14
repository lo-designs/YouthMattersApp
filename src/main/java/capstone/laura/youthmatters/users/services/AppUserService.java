package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.users.models.AppUser;
import org.springframework.stereotype.Component;

import java.util.List;

public interface AppUserService {

    void saveAppUser(AppUser appUser);

}