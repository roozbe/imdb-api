package net.roozbe.imdb.controller;

import net.roozbe.imdb.da.repository.ApiLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HttpRequestController.class)
class HttpRequestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiLogRepository apiLogRepository;

    @BeforeEach
    void setUp() {
        Mockito.reset(apiLogRepository);
    }

    @Test
    void testGetRequestCount() throws Exception {
        // Arrange
        List<Map<String, Long>> mockRequestCounts = List.of(Map.of("count", 100L));
        when(apiLogRepository.countRequests()).thenReturn(mockRequestCounts);

        // Act & Assert
        mockMvc.perform(get("/api/requests/count"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"count\":100}]"));
    }
}