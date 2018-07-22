package com.codetudes.dogeapi.service.impl;

import com.codetudes.dogeapi.config.Mapper;
import com.codetudes.dogeapi.config.error.ResourceNotFoundException;
import com.codetudes.dogeapi.contract.AppUserDTO;
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

    @Autowired
    Mapper mapper;

    @Override
    public AppUserDTO createAppUser(AppUserDTO appUserDTO) {
        AppUser appUser = mapper.map(appUserDTO, AppUser.class);
        return mapper.map(appUserRepository.save(appUser), AppUserDTO.class);
    }

    public AppUserDTO findAppUser(Long id) {
        Optional<AppUser> appUser = appUserRepository.findById(id);
        if (!appUser.isPresent()) {
            throw new ResourceNotFoundException();
        }

        return mapper.map(appUser.get(), AppUserDTO.class);
    }

    public AppUserDTO updateAppUser(AppUserDTO appUserDTO) {
        Optional<AppUser> appUser = appUserRepository.findById(appUserDTO.getId());
        if (!appUser.isPresent()) {
            throw new ResourceNotFoundException();
        }

        AppUser oldEntity = appUser.get();
        mapper.map(appUserDTO, oldEntity);

        AppUser newEntity = appUserRepository.save(oldEntity);
        return mapper.map(oldEntity, AppUserDTO.class);

    }

    public Boolean deleteAppUser(Long id) {
        if (appUserRepository.existsById(id)) {
            appUserRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
