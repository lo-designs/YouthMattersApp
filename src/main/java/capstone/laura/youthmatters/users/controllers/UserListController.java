package capstone.laura.youthmatters.users.controllers;

import capstone.laura.youthmatters.users.models.UserList;
import capstone.laura.youthmatters.users.services.UserListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserListController {

    private UserListService userListService;

    @GetMapping("/userlist")
    public String viewUserList(Model model) {
        model.addAttribute("listUserLists", userListService.getAllUserLists());
        return "user_list";
    }

    @GetMapping("/showNewUserListForm")
    public String showNewUserListForm(Model model) {
        UserList userList = new UserList();
        model.addAttribute("userList", userList);
        return "new_list";
    }

    // SAVE RESOURCE LIST

    @PostMapping("/saveUserList")
    public String saveResourceList(@ModelAttribute("resourceList") UserList userList) {
        userListService.saveUserList(userList);
        return "redirect:/userList";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        UserList userList = userListService.getUserListById(id);
        model.addAttribute("userList", userList);
        return "update_list";
    }

    @GetMapping("deleteUserList/{id}")
    public String deleteUserList(@PathVariable(value = "id") long id) {
        this.userListService.deleteUserListById(id);
        return "redirect:/user_list";
    }
}
