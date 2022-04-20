package capstone.laura.youthmatters.hotlines;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HotlineController {

    private HotlineService hotlineService;

    @GetMapping("/hotlines")
    public String getAllHotlines(Model model) {
        model.addAttribute("hotlines", hotlineService.getAllHotlineLists());
        return "hotlines";
    }
}
