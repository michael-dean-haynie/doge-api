package com.codetudes.dogeapi.service;

import com.codetudes.dogeapi.contract.AppUserDTO;

public interface AppUserService {
    AppUserDTO createAppUser(AppUserDTO appUserDTO);

    AppUserDTO findAppUser(Long id);

    AppUserDTO updateAppUser(AppUserDTO appUserDTO);

    Boolean deleteAppUser(Long id);
}
