package capstone.laura.youthmatters.youth.resources.controllers;

import capstone.laura.youthmatters.user.AppUser;
import capstone.laura.youthmatters.user.AppUserService;
import capstone.laura.youthmatters.youth.resources.services.ResourceService;
import capstone.laura.youthmatters.youth.resources.models.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class ResourceController {

    // CONTROLLER FOR ADMIN TO ADD, UPDATE, AND DELETE RESOURCES
    private ResourceService resourceService;
    private AppUserService appUserService;

    @Autowired
    public ResourceController(ResourceService resourceService, AppUserService appUserService) {
        this.resourceService = resourceService;
        this.appUserService = appUserService;
    }

    // SHOW LIST OF RESOURCES

    @GetMapping("/all_resources")
    public String getAllResources(Model model) {
        model.addAttribute("allResources", resourceService.getAllResources());
        return "all_resources";
    }


    @GetMapping("/showNewResourceForm")
    public String showNewResourceForm(Model model) {
        Resource resource = new Resource();
        model.addAttribute("resource", resource);
        return "new_resource";
    }

   @PostMapping("/saveResource")
    public String saveResource(@ModelAttribute("resource") @Valid Resource resource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_resource";
        }
        // SAVE RESOURCE TO DATABASE
       resourceService.saveResource(resource);
        return "redirect:/all_resources";
   }

   @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // GET RESOURCE FROM SERVICE
       Resource resource = resourceService.getResourceById(id);

       // SET RESOURCE AS MODEL ATTRIBUTE TO PRE-POPULATE FORM
       model.addAttribute("resource", resource);
       return "update_resource";
   }

   @GetMapping("/deleteResource/{id}")
    public String deleteResource(@PathVariable(value = "id") long id) {

        // CALL DELETE RESOURCE METHOD
       this.resourceService.deleteResourceById(id);
       return "redirect:/all_resources";
   }

   // SAVES RESOURCE TO USER ON USER ACCOUNT PAGE
   @PostMapping("/saveResourceToUser/{id}")
    public String saveResourceToUser(@PathVariable(value = "id") long id, Principal principal) {
       Resource resource = resourceService.getResourceById(id);
       AppUser appUser = appUserService.findUserByEmail(principal.getName());
       appUserService.saveResourceToUser(resource, appUser.getId());
       return "redirect:/account";
   }

}
