package com.opticamejia.app.controllers;

import com.opticamejia.app.models.UserModel;
import com.opticamejia.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id")Integer id) {
        boolean ok = this.userService.deleteUser(id);
        if(ok) {
            return "Usuario eliminado correctamente";
        } else {
            return "Error al eliminar el usuario";
        }
    }
}
