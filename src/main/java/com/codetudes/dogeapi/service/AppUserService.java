package com.codetudes.dogeapi.service;

import com.codetudes.dogeapi.db.entity.AppUser;

import java.util.Optional;

public interface AppUserService {
    AppUser createAppUser(String email, String secret);
    Optional<AppUser> findAppUser(Long id);
    Boolean deleteAppUser(Long id);
}
