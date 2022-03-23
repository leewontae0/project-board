package project.projectboard.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.projectboard.domain.User;
import project.projectboard.repository.UserRepository;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/users/add")
    public String addUser(@ModelAttribute(name = "user") User user) {
        return "users/addUserForm";
    }

    @PostMapping("/users/add")
    public String saveUser(@Validated @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "users/addUserForm";
        }

        userRepository.save(user);
        return "redirect:/";

    }
}
