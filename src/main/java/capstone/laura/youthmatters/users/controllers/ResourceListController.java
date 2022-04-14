package capstone.laura.youthmatters.users.controllers;

import capstone.laura.youthmatters.users.models.ResourceList;
import capstone.laura.youthmatters.users.services.ResourceListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResourceListController {

    private ResourceListService resourceListService;

    @GetMapping("/resourcelist")
    public String viewResourceList(Model model) {
        model.addAttribute("listResourceLists", resourceListService.getAllResourceLists());
        return "list";
    }

    @GetMapping("/showNewResourceListForm")
    public String showNewResourceListForm(Model model) {
        ResourceList resourceList = new ResourceList();
        model.addAttribute("resourceList", resourceList);
        return "new_list";
    }

    // SAVE RESOURCE LIST

    @PostMapping("/saveResourceList")
    public String saveResourceList(@ModelAttribute("resourceList") ResourceList resourceList) {
        resourceListService.saveResourceList(resourceList);
        return "redirect:/resourceList";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        ResourceList resourceList = resourceListService.getResourceListById(id);
        model.addAttribute("resourceList", resourceList);
        return "update_list";
    }

    @GetMapping("deleteResourceList/{id}")
    public String deleteResourceList(@PathVariable(value = "id") long id) {
        this.resourceListService.deleteResourceListById(id);
        return "redirect:/resourceList";
    }
}
