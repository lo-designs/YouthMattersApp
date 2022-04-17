package capstone.laura.youthmatters.users.controllers;

import capstone.laura.youthmatters.resources.models.Resource;
import capstone.laura.youthmatters.resources.models.ResourceTag;
import capstone.laura.youthmatters.resources.services.ResourceService;
import capstone.laura.youthmatters.resources.services.ResourceTagService;
import capstone.laura.youthmatters.users.models.AppUser;
import capstone.laura.youthmatters.users.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
//@RequestMapping("/register")
public class AppUserController {

    private final AppUserService appUserService;

    private final ResourceTagService resourceTagService;

    private final ResourceService resourceService;

    @Autowired
    public AppUserController(AppUserService appUserService, ResourceTagService resourceTagService, ResourceService resourceService) {
        this.appUserService = appUserService;
        this.resourceTagService = resourceTagService;
        this.resourceService = resourceService;
    }

    // HOME/ABOUT/HOTLINES

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/get_started")
    public String getStarted() {
        return "get_started";
    }

    @GetMapping("/hotlines")
    public String hotlines() {
        return "hotlines";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/resources")
    public String resources() {
        return "resources";
    }

    @GetMapping("/account")
    public String account(Model model) {
    AppUser appUser = appUserService.getUserById(65);
    List<Long> tagIds = appUser.getTags().stream().map(ResourceTag::getId).collect(Collectors.toList());
    List<Resource> resources = resourceService.getResourcesByTags(tagIds);
        model.addAttribute("resources", resources);
        return "account";
    }

    // I. DISPLAYS SIGNUP FOR USER (1: GENERAL INFO)

    @GetMapping("/register")
    public String register(Model model) {
        AppUser appUser = new AppUser();
        model.addAttribute("appUser", appUser);
        return "register";
    }

    // II. SUBMIT USER FORM--IF VALID, CREATE USER
    // REGISTER/SIGNUP 1: PRIMARY NEEDS

    @PostMapping("/register/step_1")
    public String register1(@ModelAttribute("appUser") AppUser appUser, Model model) {
        List<ResourceTag> primaryNeedsTags = resourceTagService.getAllTagsFromCategory("primary needs");
        appUserService.saveAppUser(appUser);
        model.addAttribute("tags", primaryNeedsTags);
        model.addAttribute("header","1 | What are your primary needs?");
        model.addAttribute("subheader", "[ what are your main reasons for using this app? ]");
        model.addAttribute("url","register/step_2");
        return "register_options";
    }

    // REGISTER/SIGNUP 2: TYPES OF HELP

    @PostMapping("/register/step_2")
    public String register2(Model model, @ModelAttribute SelectionDto optionIds) {
        optionIds.getIds().removeIf(Objects::isNull);
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.getUserById(65);
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        List<ResourceTag> mentalHealthTags = resourceTagService.getAllTagsFromCategory("mental health");
        model.addAttribute("tags", mentalHealthTags);
        model.addAttribute("header","2 | What types of help are you looking for?");
        model.addAttribute("subheader", "[ select all options that best fit the type of help you need. ]");
        model.addAttribute("url","register/step_3");
        return "register_options";
    }

    // REGISTER/SIGNUP 3: IDENTIFIERS

    @PostMapping("/register/step_3")
    public String register3(Model model, @ModelAttribute SelectionDto optionIds) {
        optionIds.getIds().removeIf(Objects::isNull);
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.getUserById(65);
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        List<ResourceTag> identifierTags = resourceTagService.getAllTagsFromCategory("identifiers");
        model.addAttribute("tags", identifierTags);
        model.addAttribute("header","3 | Identifiers");
        model.addAttribute("subheader", "[ provide identifiers if you'd like to narrow down resources with those considerations. ]");
        model.addAttribute("url","register/step_4");
        return "register_options";
    }

    // REGISTER/SIGNUP 4: INCOME

//    @PostMapping("/register/step_4")
//    public String register4(Model model, @ModelAttribute SelectionDto optionIds) {
//        optionIds.getIds().removeIf(Objects::isNull);
//        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
//        AppUser user = appUserService.getUserById(55);
//        user.getTags().addAll(selectedTags);
//        appUserService.saveAppUser(user);
//        List<ResourceTag> incomeTags = resourceTagService.getAllTagsFromCategory("income");
//        model.addAttribute("tags", incomeTags);
//        model.addAttribute("header","4 | Income");
//        model.addAttribute("subheader", "[ providing income & insurance details help to find only those that fit your income requirements ]");
//        model.addAttribute("url", "register/step_5");
//        return "register_options";
//    }

    // REGISTER/SIGNUP 5: RESOURCE TYPE

    @PostMapping("/register/step_4")
    public String register5(Model model, @ModelAttribute SelectionDto optionIds) {
        optionIds.getIds().removeIf(Objects::isNull);
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.getUserById(65);
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        List<ResourceTag> resourceTags = resourceTagService.getAllTagsFromCategory("resource");
        model.addAttribute("tags", resourceTags);
        model.addAttribute("header","4 | Types of resources");
        model.addAttribute("subheader", "[ narrow your options based on the types of resources you want. ]");
        model.addAttribute("url", "register_success");
        return "register_options";
    }

    @PostMapping("/register_success")
    public String register_success(@ModelAttribute SelectionDto optionIds) {
        optionIds.getIds().removeIf(Objects::isNull);
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.getUserById(65);
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        return "register_success";
    }
}
