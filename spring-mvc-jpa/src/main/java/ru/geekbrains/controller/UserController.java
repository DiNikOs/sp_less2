package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.persistence.UserRepository;
import ru.geekbrains.persistence.entity.Category;
import ru.geekbrains.persistence.entity.User;


@Controller
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @RequestMapping(value = "createUser", method = RequestMethod.GET)
    public String createUserFrom(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("action", "create");
        return "user";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editUserForm(@RequestParam("id") Long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        model.addAttribute("user", user);
        model.addAttribute("action", "edit");
        return "user";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editUserForm(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/users";
    }
}
