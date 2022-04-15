package capstone.laura.youthmatters.users.services;

import capstone.laura.youthmatters.users.models.UserList;

import java.util.List;

public interface UserListService {

    List<UserList> getAllUserLists();
    void saveUserList(UserList userList);
    UserList getUserListById(long id);
    void deleteUserListById(long id);
}
