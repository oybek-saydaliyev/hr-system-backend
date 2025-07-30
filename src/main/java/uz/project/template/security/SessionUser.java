package uz.project.template.security;

import org.springframework.security.core.context.SecurityContextHolder;
import uz.project.template.entity.AuthUserEntity;

import java.util.Optional;

public class SessionUser {

    public static Optional<AuthUserEntity> getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof AuthUserEntity) {
            return Optional.of((AuthUserEntity) principal);
        }
        return Optional.empty();
    }

}
