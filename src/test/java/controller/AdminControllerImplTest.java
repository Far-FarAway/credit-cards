package controller;

import org.minibank.admin.controller.AdminControllerImpl;
import org.minibank.admin.service.AdminService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.minibank.creditCard.dto.NewCreditCardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AdminControllerImpl.class)
class AdminControllerImplTest {
    @MockBean
    AdminService service;
    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    void createCardWithWrongOwnerId() throws Exception {
        NewCreditCardDto dto = NewCreditCardDto.builder()
                .ownerId(-3L)
                .build();

        mvc.perform(post("admins/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().is(400));
    }

    @Test
    void updateCardWithWrongBalance() throws Exception {
        NewCreditCardDto dto = NewCreditCardDto.builder()
                .balance(-3)
                .build();

        mvc.perform(patch("admins/cards/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(dto)))
                .andExpect(status().is(400));
    }
}