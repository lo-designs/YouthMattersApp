package capstone.laura.youthmatters.users.controllers;

import capstone.laura.youthmatters.organizations.models.OrgTag;
import capstone.laura.youthmatters.organizations.services.OrgTagService;
import capstone.laura.youthmatters.users.models.AppUser;
import capstone.laura.youthmatters.users.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/register")
public class AppUserController {

    private final AppUserService appUserService;

    private final OrgTagService orgTagService;

    @Autowired
    public AppUserController(AppUserService appUserService, OrgTagService orgTagService) {
        this.appUserService = appUserService;
        this.orgTagService = orgTagService;
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

    @GetMapping("/getstarted")
    public String getStarted() {
        return "getStarted";
    }

    @GetMapping("/accountcreated")
    public String accountCreated() {
        return "accountCreated";
    }

    @GetMapping("/hotlines")
    public String hotlines() {
        return "hotlines";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // I. DISPLAYS SIGNUP FOR USER (1: GENERAL INFO)

    @GetMapping("/signup")
    public String signup(Model model) {
        AppUser appUser = new AppUser();
        model.addAttribute("appUser", appUser);
        return "signup";
    }

    // II. SUBMIT USER FORM--IF VALID, CREATE USER
    // REGISTER/SIGNUP 1: PRIMARY NEEDS

    @PostMapping("/register1")
    public String register1(@ModelAttribute("appUser") AppUser appUser, Model model) {
        List<OrgTag> primaryNeedsTags = orgTagService.getAllTagsFromCategory("primary needs");
        appUserService.saveAppUser(appUser);
        model.addAttribute("tags", primaryNeedsTags);
        model.addAttribute("header","1 | What are your primary needs?");
        model.addAttribute("subheader", "[ what are your main reasons for using this app? ]");
        model.addAttribute("url","register2");
        return "register";
    }

    // REGISTER/SIGNUP 2: TYPES OF HELP

    @PostMapping("/register2")
    public String register2(@ModelAttribute("appUser") AppUser appUser, Model model) {
        List<OrgTag> mentalHealthTags = orgTagService.getAllTagsFromCategory("mental health");
        appUserService.saveAppUser(appUser);
        model.addAttribute("tags", mentalHealthTags);
        model.addAttribute("header","2 | What types of help are you looking for?");
        model.addAttribute("subheader", "[ select all options that best fit the type of help you need. ]");
        model.addAttribute("url","register3");
        return "register";
    }

    // REGISTER/SIGNUP 3: IDENTIFIERS

    @PostMapping("/register3")
    public String register3(@ModelAttribute("appUser") AppUser appUser, Model model) {
        List<OrgTag> identifierTags = orgTagService.getAllTagsFromCategory("identifiers");
        appUserService.saveAppUser(appUser);
        model.addAttribute("tags", identifierTags);
        model.addAttribute("header","3 | Identifiers");
        model.addAttribute("subheader", "[ provide identifiers if you'd like to narrow down resources with those considerations. ]");
        model.addAttribute("url","register4");
        return "register";
    }

    // REGISTER/SIGNUP 4: INCOME

    @PostMapping("/register4")
    public String register4(@ModelAttribute("appUser") AppUser appUser, Model model) {
        List<OrgTag> incomeTags = orgTagService.getAllTagsFromCategory("income");
        appUserService.saveAppUser(appUser);
        model.addAttribute("tags", incomeTags);
        model.addAttribute("header","4 | Identifiers");
        model.addAttribute("subheader", "[ provide identifiers if you'd like to narrow down resources with those considerations. ]");
        model.addAttribute("url", "register5");
        return "register";
    }

    // REGISTER/SIGNUP 5: RESOURCE TYPE

    @PostMapping("/register5")
    public String register5(@ModelAttribute("appUser") AppUser appUser, Model model) {
        List<OrgTag> resourceTags = orgTagService.getAllTagsFromCategory("resource");
        appUserService.saveAppUser(appUser);
        model.addAttribute("tags", resourceTags);
        model.addAttribute("header","5 | Types of resources");
        model.addAttribute("subheader", "[ narrow your options based on the types of resources you want. ]");
        model.addAttribute("url", "accountcreated");
        return "accountCreated";
    }

}
