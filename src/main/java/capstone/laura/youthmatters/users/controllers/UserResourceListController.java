package capstone.laura.youthmatters.users.controllers;

import capstone.laura.youthmatters.users.models.UserResourceList;
import capstone.laura.youthmatters.users.services.UserResourceListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserResourceListController {

    private UserResourceListService userResourceListService;

//    @GetMapping("/account")
//    public String viewResourceList(Model model) {
//        model.addAttribute("listResourceLists", userResourceListService.getAllResourceLists());
//        return "account";
//    }

    @GetMapping("/showNewUserResourceListForm")
    public String showNewResourceListForm(Model model) {
        UserResourceList userResourceList = new UserResourceList();
        model.addAttribute("resourceList", userResourceList);
        return "new_list";
    }

    // SAVE RESOURCE LIST

    @PostMapping("/saveUserResourceList")
    public String saveResourceList(@ModelAttribute("resourceList") UserResourceList userResourceList) {
        userResourceListService.saveUserResourceList(userResourceList);
        return "redirect:/account";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        UserResourceList userResourceList = userResourceListService.getUserResourceListById(id);
        model.addAttribute("userResourceList", userResourceList);
        return "update_list";
    }

    @GetMapping("deleteResourceList/{id}")
    public String deleteUserResourceList(@PathVariable(value = "id") long id) {
        this.userResourceListService.deleteUserResourceListById(id);
        return "redirect:/account";
    }
}
