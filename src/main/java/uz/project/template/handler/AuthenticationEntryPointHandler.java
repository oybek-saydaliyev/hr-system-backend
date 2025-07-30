package uz.project.template.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper;

    public AuthenticationEntryPointHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        Map<String, Object> result = new HashMap<>();
        result.put("message", authException.getMessage());
        result.put("errorCode", 401);
        result.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
