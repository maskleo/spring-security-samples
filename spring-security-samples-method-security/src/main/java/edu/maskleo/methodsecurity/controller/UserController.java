package edu.maskleo.methodsecurity.controller;

import edu.maskleo.methodsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  // 指定角色权限才能操作方法
    @GetMapping(value = "delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id, Model model) {
        userService.removeUser(id);
        model.addAttribute("userList", userService.listUsers());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }
}
