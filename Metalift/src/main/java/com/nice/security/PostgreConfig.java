package io.example.configuration;

import com.nice.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.UUID;

import static java.util.Optional.ofNullable;

@Configuration @EnableJpaAuditing
public class PostgreConfig {

    @Bean
    public AuditorAware<UUID> auditorProvider() {
        return () -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User user = null;
            if (authentication != null && authentication.getPrincipal() instanceof User) {
                user = (User) authentication.getPrincipal();
            }
            return ofNullable(user).map(User::getId);
        };
    }

}