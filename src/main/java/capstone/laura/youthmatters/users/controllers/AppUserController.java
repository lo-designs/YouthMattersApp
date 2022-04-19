package capstone.laura.youthmatters.users.controllers;

import capstone.laura.youthmatters.healthresources.models.Resource;
import capstone.laura.youthmatters.healthresources.models.ResourceTag;
import capstone.laura.youthmatters.healthresources.services.ResourceService;
import capstone.laura.youthmatters.healthresources.services.ResourceTagService;
import capstone.laura.youthmatters.security.AppUserDetailsService;
import capstone.laura.youthmatters.security.AppUserDto;
import capstone.laura.youthmatters.security.AppUser;
import capstone.laura.youthmatters.users.models.SelectionDto;
import capstone.laura.youthmatters.users.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
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

//    @GetMapping("/resources")
//    public String resources() {
//        return "resources";
//    }

    @GetMapping("/account")
    public String account(Model model, Principal principal) {
    AppUser appUser = appUserService.findUserByEmail(principal.getName());
    List<Long> tagIds = appUser.getTags().stream().map(ResourceTag::getId).collect(Collectors.toList());
        System.out.println(tagIds);
    List<Resource> resources = resourceService.getResourcesByTags(tagIds);
        System.out.println(resources);
        model.addAttribute("resources", resources);
        return "account";
    }

    // I. DISPLAYS SIGNUP FOR USER (1: GENERAL INFO)


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("appUser", new AppUserDto());
        return "register";
    }

    // II. SUBMIT USER FORM--IF VALID, CREATE USER
    // REGISTER/SIGNUP 1: PRIMARY NEEDS

    @GetMapping("/account_setup/step_1")
    public String register1(Model model) {
        List<ResourceTag> primaryNeedsTags = resourceTagService.getAllTagsFromCategory("primary needs");
        model.addAttribute("tags", primaryNeedsTags);
        model.addAttribute("header","1 | What are your primary needs?");
        model.addAttribute("subheader", "[ what are your main reasons for using this app? ]");
        model.addAttribute("url","account_setup/step_2");
        return "register_options";
    }

    // REGISTER/SIGNUP 2: TYPES OF HELP

    @PostMapping("/account_setup/step_2")
    public String register2(Model model, @ModelAttribute SelectionDto optionIds, Principal principal) {
        if (!optionIds.getIds().isEmpty()) {
            optionIds.getIds().removeIf(Objects::isNull);
        }
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.findUserByEmail(principal.getName());
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        List<ResourceTag> mentalHealthTags = resourceTagService.getAllTagsFromCategory("mental health");
        model.addAttribute("tags", mentalHealthTags);
        model.addAttribute("header","2 | What types of help are you looking for?");
        model.addAttribute("subheader", "[ select all options that best fit the type of help you need. ]");
        model.addAttribute("url","account_setup/step_3");
        return "register_options";
    }

    // REGISTER/SIGNUP 3: IDENTIFIERS

    @PostMapping("/account_setup/step_3")
    public String register3(Model model, @ModelAttribute SelectionDto optionIds, Principal principal) {
        if (!optionIds.getIds().isEmpty()) {
            optionIds.getIds().removeIf(Objects::isNull);
        }
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.findUserByEmail(principal.getName());
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        List<ResourceTag> identifierTags = resourceTagService.getAllTagsFromCategory("identifiers");
        model.addAttribute("tags", identifierTags);
        model.addAttribute("header","3 | Identifiers");
        model.addAttribute("subheader", "[ provide identifiers if you'd like to narrow down resources with those considerations. ]");
        model.addAttribute("url","account_setup/step_4");
        return "register_options";
    }

//     REGISTER/SIGNUP 4: INCOME

    @PostMapping("/account_setup/step_4")
    public String register4(Model model, @ModelAttribute SelectionDto optionIds, Principal principal) {
        if (!optionIds.getIds().isEmpty()) {
            optionIds.getIds().removeIf(Objects::isNull);
        }
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.findUserByEmail(principal.getName());
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        List<ResourceTag> incomeTags = resourceTagService.getAllTagsFromCategory("income");
        model.addAttribute("tags", incomeTags);
        model.addAttribute("header","4 | Income");
        model.addAttribute("subheader", "[ providing income & insurance details help to find only those that fit your income requirements ]");
        model.addAttribute("url", "account_setup/step_5");
        return "register_options";
    }

    // REGISTER/SIGNUP 5: RESOURCE TYPE

    @PostMapping("/account_setup/step_5")
    public String register5(Model model, @ModelAttribute SelectionDto optionIds, Principal principal) {
        if (!optionIds.getIds().isEmpty()) {
            optionIds.getIds().removeIf(Objects::isNull);
        }
        List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
        AppUser user = appUserService.findUserByEmail(principal.getName());
        user.getTags().addAll(selectedTags);
        appUserService.saveAppUser(user);
        List<ResourceTag> resourceTags = resourceTagService.getAllTagsFromCategory("resource");
        model.addAttribute("tags", resourceTags);
        model.addAttribute("header","5 | Types of resources");
        model.addAttribute("subheader", "[ narrow your options based on the types of resources you want. ]");
        model.addAttribute("url", "account_setup/complete");
        return "register_options";
    }

    @PostMapping("/account_setup/complete")
    public String register_success(@ModelAttribute SelectionDto optionIds, Principal principal) {
        if (!optionIds.getIds().isEmpty()) {
            optionIds.getIds().removeIf(Objects::isNull);
            List<ResourceTag> selectedTags = resourceTagService.getAllTagWithIds(optionIds.getIds());
            AppUser user = appUserService.findUserByEmail(principal.getName());
            user.getTags().addAll(selectedTags);
            appUserService.saveAppUser(user);
        }
        return "redirect:/account";
    }
}
