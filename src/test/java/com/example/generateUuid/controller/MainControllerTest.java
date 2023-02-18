package com.example.generateUuid.controller;

import com.example.generateUuid.entity.EmailInfo;
import com.example.generateUuid.service.UuidForEmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@WebMvcTest(MainController.class)
class MainControllerTest {
    public static final ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UuidForEmailService uuidForEmailService;

    @Test
    void sandboxPrintMain() throws Exception {
        final ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/main"));
        final MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
        final var s = mvcResult.getResponse().getContentAsString();
        assertEquals(s, "hello world");
    }

    @Test
    void post() throws Exception {
        final UUID uuid = UUID.randomUUID();
        final var uuidSrting = uuid.toString();
        final var mail ="test@test.com";
        EmailInfo emailInfoBefore = EmailInfo.builder().mail(mail).build();
        EmailInfo emailInfoAfter = EmailInfo.builder().mail(mail).uuid(uuidSrting).build();
        doReturn(uuid)
                .when(uuidForEmailService)
                .getUuid(mail);

        String body = MAPPER.writeValueAsString(emailInfoBefore);

        final ResultActions resultActions = mockMvc
                .perform(MockMvcRequestBuilders.post("/getUuid")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                );
        final MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andReturn();
        final var s = mvcResult.getResponse().getContentAsString();
        assertEquals(s, MAPPER.writeValueAsString(emailInfoAfter));
    }
}