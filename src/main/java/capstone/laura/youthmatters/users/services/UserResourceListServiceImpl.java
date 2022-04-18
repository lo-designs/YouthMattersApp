package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.users.models.UserResourceList;
import capstone.laura.youthmatters.users.repositories.UserResourceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserResourceListServiceImpl implements UserResourceListService {

    @Autowired
    private UserResourceListRepository userResourceListRepository;

    @Override
    public List<UserResourceList> getAllUserResourceLists() {
        return userResourceListRepository.findAll();
    }

    @Override
    public void saveUserResourceList(UserResourceList userResourceList) {
        this.userResourceListRepository.save(userResourceList);
    }

    @Override
    public UserResourceList getUserResourceListById(long id) {
        Optional<UserResourceList> optional = userResourceListRepository.findById(id);
        UserResourceList userResourceList = null;
        if (optional.isPresent()) {
            userResourceList = optional.get();
        } else {
            throw new RuntimeException("not found for id:: " + id);
        }
        return userResourceList;
    }

    @Override
    public void deleteUserResourceListById(long id) {
        this.userResourceListRepository.deleteById(id);
    }
}
