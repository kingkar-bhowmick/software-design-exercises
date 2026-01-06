package de.example.discountshop.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerIT {

  @Autowired
  MockMvc mvc;

  @Test
  void createOrder_returns201AndLocation() throws Exception {
    mvc.perform(post("/orders"))
        .andExpect(status().isCreated())
        .andExpect(header().exists("Location"))
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.status").value("CREATED"));
  }

  @Test
  void addItem_quantityZero_returns400ProblemDetails() throws Exception {
    var res = mvc.perform(post("/orders"))
        .andExpect(status().isCreated())
        .andReturn();

    String body = res.getResponse().getContentAsString();
    String id = body.replaceAll(".*\"id\"\s*:\s*\"([^\"]+)\".*", "$1");

    mvc.perform(post("/orders/" + id + "/items")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"productId\":\"P1\",\"quantity\":0}"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.type").value("urn:problem-type:validation-error"))
        .andExpect(jsonPath("$.errors").isArray());
  }
}
