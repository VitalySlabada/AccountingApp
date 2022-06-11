package com.example.accountingapp.controller;


import com.example.accountingapp.dto.UserDTO;
import com.example.accountingapp.enums.UserStatus;
import com.example.accountingapp.service.CompanyService;
import com.example.accountingapp.service.RoleService;
import com.example.accountingapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;
    private final CompanyService companyService;

    public UserController(UserService userService, RoleService roleService, CompanyService companyService) {
        this.userService = userService;
        this.roleService = roleService;
        this.companyService = companyService;
    }

    @GetMapping("/list")
    public String listUser(Model model) {


        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("users", userService.listAllUsers());
        model.addAttribute("UserStatus", UserStatus.values());
        return "/user/user-list";
    }


    @GetMapping("/add")
    public String addUser(Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("UserStatus", UserStatus.values());
        return "/user/user-add";
    }


    @PostMapping("/add")
    public String insertUser(@ModelAttribute("user") UserDTO user, Model model) {

        model.addAttribute("user", new UserDTO());
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("UserStatus", UserStatus.values());
        userService.save(user);
        return "/user/user-add";

    }


    @GetMapping("/update/{email}")
    public String editUser(@PathVariable("email") String email, Model model) {

        model.addAttribute("user", userService.findByEmail(email));
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("users", userService.listAllUsers());
        model.addAttribute("UserStatus", UserStatus.values());
        return "/user/user-update";

    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDTO user, Model model) {

        userService.update(user);
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("users", userService.listAllUsers());
        model.addAttribute("UserStatus", UserStatus.values());
        return "user/user-list";

    }


    @GetMapping("/delete/{email}")
    public String deleteUser(@PathVariable("email") String email, Model model) {

        userService.delete(email);
        model.addAttribute("roles", roleService.listAllRoles());
        model.addAttribute("companies", companyService.listAllCompanies());
        model.addAttribute("users", userService.listAllUsers());
        model.addAttribute("UserStatus", UserStatus.values());

        return "user/user-list";
    }


}