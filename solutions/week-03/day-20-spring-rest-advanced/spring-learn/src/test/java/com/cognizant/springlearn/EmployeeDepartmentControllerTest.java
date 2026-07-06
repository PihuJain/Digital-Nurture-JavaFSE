package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeDepartmentControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllEmployeesReturnsFour() throws Exception {
        mvc.perform(get("/employees")).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    void getAllDepartmentsReturnsTwo() throws Exception {
        mvc.perform(get("/departments")).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void updateEmployeeChangesTheName() throws Exception {
        String payload = "{\"id\":1,\"name\":\"Riya Sharma\",\"salary\":58000,\"permanent\":true}";
        mvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(status().isOk());
    }

    @Test
    void updateUnknownEmployeeReturns404() throws Exception {
        String payload = "{\"id\":99,\"name\":\"Ghost\",\"salary\":1000,\"permanent\":true}";
        mvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(status().isNotFound())
                .andExpect(status().reason("Employee not found"));
    }

    @Test
    void updateEmployeeWithBlankNameFailsValidation() throws Exception {
        String payload = "{\"id\":2,\"name\":\"\",\"salary\":1000,\"permanent\":true}";
        mvc.perform(put("/employees").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").isArray());
    }

    // the employee list is a plain in-memory ArrayList, not a real database that
    // rolls back after each test - deleting for real here would bleed into whichever
    // test runs next, so @DirtiesContext forces a fresh bean (and a fresh xml load)
    // straight after this one
    @Test
    @DirtiesContext
    void deleteEmployeeRemovesItFromTheList() throws Exception {
        mvc.perform(delete("/employees/4")).andExpect(status().isOk());
        mvc.perform(get("/employees")).andExpect(jsonPath("$.length()").value(3));
    }

    @Test
    void deleteUnknownEmployeeReturns404() throws Exception {
        mvc.perform(delete("/employees/99")).andExpect(status().isNotFound());
    }

    @Test
    void postCountryEchoesBackTheValidPayload() throws Exception {
        String payload = "{\"code\":\"FR\",\"name\":\"France\"}";
        mvc.perform(post("/countries").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("FR"));
    }

    @Test
    void postCountryWithBadCodeFailsValidation() throws Exception {
        String payload = "{\"code\":\"FRA\",\"name\":\"France\"}";
        mvc.perform(post("/countries").contentType(MediaType.APPLICATION_JSON).content(payload))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0]").value("Country code should be 2 characters"));
    }
}
