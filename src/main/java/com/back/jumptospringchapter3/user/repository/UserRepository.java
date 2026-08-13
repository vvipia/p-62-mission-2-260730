package com.back.jumptospringchapter3.user.repository;

import com.back.jumptospringchapter3.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}
