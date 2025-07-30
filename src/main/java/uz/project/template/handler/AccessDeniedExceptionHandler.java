package uz.project.template.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AccessDeniedExceptionHandler implements AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    public AccessDeniedExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        Map<String, Object> result = new HashMap<>();
        result.put("message", accessDeniedException.getMessage());
        result.put("errorCode", 403);
        result.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));

        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
