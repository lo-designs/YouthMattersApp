package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.users.models.UserResourceList;

import java.util.List;

public interface UserResourceListService {

    List<UserResourceList> getAllUserResourceLists();
    void saveUserResourceList(UserResourceList userResourceList);
    UserResourceList getUserResourceListById(long id);
    void deleteUserResourceListById(long id);
}
