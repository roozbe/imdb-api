package net.roozbe.imdb.controller;

import net.roozbe.imdb.da.entity.ApiLogEntity;
import net.roozbe.imdb.da.repository.ApiLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;

@ControllerAdvice(annotations = RestController.class)
public class ApiLoggingAdvice implements ResponseBodyAdvice<Object> {

    @Autowired
    private ApiLogRepository apiLogRepository;

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        try {
            ApiLogEntity apiLogEntity = new ApiLogEntity();

            apiLogEntity.setHttpMethod(request.getMethodValue());
            apiLogEntity.setEndpoint(((ServletServerHttpRequest) request).getServletRequest().getServletPath());
            apiLogEntity.setStatusCode(((ServletServerHttpResponse) response).getServletResponse().getStatus());
            apiLogEntity.setTimestamp(LocalDateTime.now());

            apiLogRepository.save(apiLogEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
}
