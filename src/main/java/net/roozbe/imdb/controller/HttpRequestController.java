package net.roozbe.imdb.controller;

import lombok.AllArgsConstructor;
import net.roozbe.imdb.da.repository.ApiLogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/requests")
@AllArgsConstructor
public class HttpRequestController {

    private final ApiLogRepository repository;

    @GetMapping("/count")
    public List<Map<String, Long>> getRequestCount() {
        return repository.countRequests();
    }
}
