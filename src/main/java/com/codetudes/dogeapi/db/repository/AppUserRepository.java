package com.codetudes.dogeapi.db.repository;

import com.codetudes.dogeapi.db.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Transactional
    @Modifying
    @Query("update AppUser au set au.email = :email, au.secret = :secret where au.id = :id")
    int updateAppUser(@Param("id") Long id, @Param("email") String email, @Param("secret") String secret);
}
