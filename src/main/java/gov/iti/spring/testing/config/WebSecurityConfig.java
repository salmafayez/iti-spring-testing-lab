package gov.iti.spring.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        requests ->
                                requests
                                        .requestMatchers("/users/**").permitAll()
                                        .requestMatchers("/events/**").permitAll()
                                        .requestMatchers("/event/register").permitAll()
                );
        return http.build();
    }
}
