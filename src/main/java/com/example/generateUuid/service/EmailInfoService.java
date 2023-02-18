package com.example.generateUuid.service;

import com.example.generateUuid.entity.EmailInfo;
import com.example.generateUuid.repository.EmailInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class EmailInfoService {

    private final EmailInfoRepository emailInfoRepository;


    public EmailInfo save (EmailInfo emailInfo){
        emailInfoRepository.save(emailInfo);
        log.info("email info saved in database");
        return emailInfo;
    }

    public boolean checkIfExist (String mail) {
        Optional<EmailInfo> optional = emailInfoRepository.findByMail(mail);
        return optional.isPresent();
    }

    public Optional<EmailInfo> getEmailInfoByEmail (String mail) {
        return emailInfoRepository.findByMail(mail);
    }
}
