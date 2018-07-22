package com.codetudes.dogeapi.endpoint;

import com.codetudes.dogeapi.db.entity.AppUser;
import com.codetudes.dogeapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("app-user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public AppUser createAppUser(@RequestParam("email") String email, @RequestParam("secret") String secret){
        return appUserService.createAppUser(email, secret);
    }

    @GetMapping("test")
    public Object test(){
        return "Hello world!";
    }

    @GetMapping("/{id}")
    public Object getAppUser(@RequestParam("id") Long id){
        Optional<AppUser> appUser = appUserService.findAppUser(id);
        if (appUser.isPresent()){
            return appUser.get();
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAppUser(@RequestParam("id") Long id){
        if (appUserService.deleteAppUser(id)){
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}