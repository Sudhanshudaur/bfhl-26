package com.bfhl_26_Sudhanshu.bfhl_26;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class Bfhl26ApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testGetOperationCode() throws Exception {
        mockMvc.perform(get("/bfhl"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.operation_code", is(1)));
    }

    @Test
    void testExampleA() throws Exception {
        String requestBody = "{\"data\": [\"a\", \"1\", \"334\", \"4\", \"R\", \"$\"]}";
        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.user_id", is("sudhanshu_daur_26052026")))
                .andExpect(jsonPath("$.email", is("sudhanshu.daur@example.com")))
                .andExpect(jsonPath("$.roll_number", is("ABCD123")))
                .andExpect(jsonPath("$.odd_numbers", contains("1")))
                .andExpect(jsonPath("$.even_numbers", contains("334", "4")))
                .andExpect(jsonPath("$.alphabets", contains("A", "R")))
                .andExpect(jsonPath("$.special_characters", contains("$")))
                .andExpect(jsonPath("$.sepcial_characters", contains("$")))
                .andExpect(jsonPath("$.sum", is("339")))
                .andExpect(jsonPath("$.concat_string", is("Ra")));
    }

    @Test
    void testExampleB() throws Exception {
        String requestBody = "{\"data\": [\"2\", \"a\", \"y\", \"4\", \"&\", \"-\", \"*\", \"5\", \"92\", \"b\"]}";
        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.odd_numbers", contains("5")))
                .andExpect(jsonPath("$.even_numbers", contains("2", "4", "92")))
                .andExpect(jsonPath("$.alphabets", contains("A", "Y", "B")))
                .andExpect(jsonPath("$.special_characters", contains("&", "-", "*")))
                .andExpect(jsonPath("$.sepcial_characters", contains("&", "-", "*")))
                .andExpect(jsonPath("$.sum", is("103")))
                .andExpect(jsonPath("$.concat_string", is("ByA")));
    }

    @Test
    void testExampleC() throws Exception {
        String requestBody = "{\"data\": [\"A\", \"ABCD\", \"DOE\"]}";
        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.odd_numbers", hasSize(0)))
                .andExpect(jsonPath("$.even_numbers", hasSize(0)))
                .andExpect(jsonPath("$.alphabets", contains("A", "ABCD", "DOE")))
                .andExpect(jsonPath("$.special_characters", hasSize(0)))
                .andExpect(jsonPath("$.sum", is("0")))
                .andExpect(jsonPath("$.concat_string", is("DoEaBcDa")));
    }

    @Test
    void testEmptyData() throws Exception {
        String requestBody = "{\"data\": []}";
        mockMvc.perform(post("/bfhl")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.is_success", is(true)))
                .andExpect(jsonPath("$.odd_numbers", hasSize(0)))
                .andExpect(jsonPath("$.even_numbers", hasSize(0)))
                .andExpect(jsonPath("$.alphabets", hasSize(0)))
                .andExpect(jsonPath("$.special_characters", hasSize(0)))
                .andExpect(jsonPath("$.sum", is("0")))
                .andExpect(jsonPath("$.concat_string", is("")));
    }
}
