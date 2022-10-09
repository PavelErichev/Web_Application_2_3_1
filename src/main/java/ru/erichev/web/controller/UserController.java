package ru.erichev.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.erichev.web.entity.User;
import ru.erichev.web.service.UserService;

import java.util.List;

@Controller
//@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showAllUser(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUs", allUsers);
        return "users";
    }

    @GetMapping("/user-create")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        //userService.saveUser(user);
        userService.updateUser(user);
        return "redirect:/users";
    }



    ////////////////////////////////////////////
    /*@GetMapping
    public String showAllUser(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUs", allUsers);
        return "/users";
    }

    //@RequestMapping("/addNewUser")
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/user-info";
    }

    //@RequestMapping("/saveUser")
    //@PostMapping("/addNewUser")
    @PostMapping
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    //@GetMapping("user-delete/{id}")
    //@DeleteMapping("/users/delete/{id}")
    //@GetMapping("/users/{id}")
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String updateUserForm(@PathVariable long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }*/
///////////////////////////////////////







  /*@RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }*/

/*@RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "user-info";
    }*/

    /*@RequestMapping(method = RequestMethod.GET)
    public String allUser(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users");
        model.addAttribute("userList", users);
        return "users";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUsersAll(@PathVariable("id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("editUsers");
        model.addAttribute("user", user);
        return "editUsers";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("redirect:/");
        userService.edit(user);
        return "editUsers";
    }*/
}