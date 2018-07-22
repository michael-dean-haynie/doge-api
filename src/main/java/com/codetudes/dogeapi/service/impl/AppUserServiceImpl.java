package com.codetudes.dogeapi.service.impl;

import com.codetudes.dogeapi.db.entity.AppUser;
import com.codetudes.dogeapi.db.repository.AppUserRepository;
import com.codetudes.dogeapi.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    AppUserRepository appUserRepository;

    public AppUser createAppUser(String email, String secret){
        AppUser appUser = new AppUser();
        appUser.setEmail(email);
        appUser.setSecret(secret);

        return appUserRepository.save(appUser);
    }

    public Optional<AppUser> findAppUser(Long id){
        return appUserRepository.findById(id);
    }

    public Boolean deleteAppUser(Long id){
        if (appUserRepository.existsById(id)){
            appUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
