package com.example.generateUuid.service;

import com.example.generateUuid.entity.EmailInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Log4j2
public class UuidForEmailService {

    final private EmailInfoService emailInfoService;

    public EmailInfo getUuid (String mail){
        log.info("get mail: {}", mail);

        Optional<EmailInfo> optional = emailInfoService.getEmailInfoByEmail(mail);
        if (optional.isPresent()) {
            log.info("mail: {} and Uuid: {} exist in database: ", mail, optional.get().getUuid());
            return optional.get();
        }

        String uuid = UUID.randomUUID().toString();
        log.info("Uuid created: {}", uuid);
        EmailInfo emailInfo = EmailInfo.builder().mail(mail).uuid(uuid).build();
        emailInfoService.save(emailInfo);
        return emailInfo;
    }
}
