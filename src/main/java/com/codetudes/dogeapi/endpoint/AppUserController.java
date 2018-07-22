package com.codetudes.dogeapi.endpoint;

import com.codetudes.dogeapi.config.error.ResourceNotFoundException;
import com.codetudes.dogeapi.contract.AppUserDTO;
import com.codetudes.dogeapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app-user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public AppUserDTO createAppUser(@RequestBody AppUserDTO appUserDTO) {
        return appUserService.createAppUser(appUserDTO);
    }

    @GetMapping("{id}")
    public AppUserDTO getAppUser(@PathVariable("id") Long id) {
        return appUserService.findAppUser(id);
    }

    @PatchMapping
    public AppUserDTO updateAppUser(@RequestBody AppUserDTO appUserDTO) {
        return appUserService.updateAppUser(appUserDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteAppUser(@PathVariable("id") Long id) {

        if (appUserService.deleteAppUser(id)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            throw new ResourceNotFoundException();
        }
    }

}