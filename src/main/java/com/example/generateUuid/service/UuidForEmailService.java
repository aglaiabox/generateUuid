package com.example.generateUuid.service;

import com.example.generateUuid.entity.EmailInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Log4j2
public class UuidForEmailService {

    @Cacheable("emailInfoCache")
    public EmailInfo getUuid(String mail) {
        log.info("get mail: {}", mail);
        String uuid = UUID.randomUUID().toString();
        log.info("Uuid created: {}", uuid);
        EmailInfo emailInfo = EmailInfo.builder().mail(mail).uuid(uuid).build();
        return emailInfo;
    }
}
