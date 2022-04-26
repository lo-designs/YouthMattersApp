package capstone.laura.youthmatters.helplines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelplineController {

    // CONTROLLER FOR ADMIN TO ADD, UPDATE, AND DELETE RESOURCES
    private HelplineService helplineService;

    @Autowired
    public HelplineController(HelplineService helplineService) {
        this.helplineService = helplineService;
    }

    // SHOW LIST OF RESOURCES

    @GetMapping("/helplines")
    public String getAllHelplines(Model model) {
        model.addAttribute("helplines", helplineService.getAllHelplines());
        return "helplines";
    }
}
