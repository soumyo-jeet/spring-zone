package in.soumyo.CRUDSpringBoot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private PasswordEncoder passwordEncoder;

    public SecurityConfig (PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // public endpoints are accessible to all
        // admin endpoints are accessible to admin only
        // all others are protected by username, password authentication
        http
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/api/students/**").hasRole("admin")
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }

    // in memory user creation
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("student")
                .password(passwordEncoder.encode("student"))
                .roles("student")
                .build();

        return new InMemoryUserDetailsManager(user1);
    }
}