package in.soumyo.CRUDSpringBoot.config;

import in.soumyo.CRUDSpringBoot.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    private PasswordEncoder passwordEncoder;
    private JwtAuthFilter jwtAuthFilter;


    public SecurityConfig(PasswordEncoder passwordEncoder, JwtAuthFilter jwtAuthFilter) {
        this.passwordEncoder = passwordEncoder;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // auth endpoints are accessible to all
        // admin endpoints are accessible to admin only
        // all others are protected by username, password authentication
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionConfig ->
                        sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/admin/**").hasRole("Admin")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // in memory user creation
    // @Bean
    UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("student")
                .password(passwordEncoder.encode("student"))
                .roles("student")
                .build();

        return new InMemoryUserDetailsManager(user1);
    }


    @Bean
    AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }
}