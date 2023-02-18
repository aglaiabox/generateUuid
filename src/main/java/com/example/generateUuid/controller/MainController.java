package com.example.generateUuid.controller;

import com.example.generateUuid.entity.EmailInfo;
import com.example.generateUuid.service.EmailInfoService;
import com.example.generateUuid.service.UuidForEmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@Log4j2
@RequiredArgsConstructor
public class MainController {
    final private UuidForEmailService uuidForEmailService;

    @GetMapping("/main")
    public String sandboxPrintMain() {
        log.info("we are in main method of KangTaskController, hello world");
        return "hello world";
    }

    @PostMapping("/getUuid")
    public EmailInfo post(@RequestBody EmailInfo emailInfo) {
        return uuidForEmailService.getUuid(emailInfo.getMail());
    }

}