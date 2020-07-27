package ru.kostjanoyya.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kostjanoyya.entity.User;
import ru.kostjanoyya.repositories.UserRepository;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AdminPanelController {

    private static final Logger logger = LoggerFactory.getLogger(AdminPanelController.class);

    private final UserRepository userRepository;

    @GetMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        logger.info("Admin name: {}", principal.getName());

        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("user", new User());
        return "admin";
    }

    @PostMapping("/admin/{id}")
    public String disableUser(@PathVariable("id") long id, Principal principal) {
        logger.info("User name: {}", principal.getName());
        User user =  userRepository.findById(id).get();
        user.setIsEnabled(!user.getIsEnabled());
        userRepository.save(user);
        return "redirect:/";
    }
}
