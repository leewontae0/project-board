package project.projectboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import project.projectboard.SessionConst;
import project.projectboard.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

//    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String homeV2(@SessionAttribute(name = SessionConst.LOGIN_USER, required = false) User user, Model model) {

        if (user == null) {
            return "home";
        }

        model.addAttribute("user", user);
        return "loginHome";
    }
}
