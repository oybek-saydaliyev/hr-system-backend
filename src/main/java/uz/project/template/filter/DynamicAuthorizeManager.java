package uz.project.template.filter;


import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;
import uz.project.template.service.EndPointPermissionService;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
public class DynamicAuthorizeManager implements AuthorizationManager<RequestAuthorizationContext> {


    private final EndPointPermissionService endPointPermissionService;

    public DynamicAuthorizeManager(EndPointPermissionService endPointPermissionService) {
        this.endPointPermissionService = endPointPermissionService;
    }

    @Override
    public AuthorizationDecision check(Supplier<Authentication> authentication, RequestAuthorizationContext context) {
        String requestURI = context.getRequest().getRequestURI();
        String method = context.getRequest().getMethod();

        List<String> requiredPermissions =
                endPointPermissionService.getRequiredPermissions(requestURI, method);

        //if not permission to this uri
        if (requiredPermissions.isEmpty()) {
            return new AuthorizationDecision(true);
        }

        Authentication auth = authentication.get();

        if (auth == null || !auth.isAuthenticated()) {
            return new AuthorizationDecision(false);
        }

        Set<String> userPermissions = getUserPermissions(auth);

        boolean hasRequiredPermission  = requiredPermissions.stream().anyMatch(userPermissions::contains);
        return new AuthorizationDecision(hasRequiredPermission);
    }

    private Set<String> getUserPermissions(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .filter(authority -> !authority.startsWith("ROLE_"))
                .collect(Collectors.toSet());
    }


}
