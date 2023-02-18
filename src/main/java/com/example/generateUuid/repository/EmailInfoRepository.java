package com.example.generateUuid.repository;

import com.example.generateUuid.entity.EmailInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmailInfoRepository extends JpaRepository<EmailInfo, Long> {

    Optional<EmailInfo> findByMail(String mail);
}
