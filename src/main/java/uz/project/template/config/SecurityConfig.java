package uz.project.template.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import uz.project.template.filter.DynamicAuthorizeManager;
import uz.project.template.handler.AccessDeniedExceptionHandler;
import uz.project.template.handler.AuthenticationEntryPointHandler;
import uz.project.template.security.JwtFiler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {
    //enter your white list
    private static final String[] WHITE_LIST = {

    };

    private final JwtFiler jwtFiler;
    private final DynamicAuthorizeManager dynamicAuthorizeManager;

    public SecurityConfig(JwtFiler jwtFiler, DynamicAuthorizeManager dynamicAuthorizeManager) {
        this.jwtFiler = jwtFiler;
        this.dynamicAuthorizeManager = dynamicAuthorizeManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AccessDeniedExceptionHandler accessDeniedHandler, AuthenticationEntryPointHandler authenticationEntryPointHandler) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(
                authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(WHITE_LIST).permitAll()
                                .anyRequest().access(dynamicAuthorizeManager));
        http.sessionManagement(sessionManagement ->
                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(jwtFiler, UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling(exceptionHandling ->
                exceptionHandling.accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(authenticationEntryPointHandler));
        return http.build();
    }

}
