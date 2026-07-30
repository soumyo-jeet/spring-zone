package in.soumyo.CRUDSpringBoot;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private AuthUtil authUtil;
    private StudentRepository repository;

    public JwtAuthFilter(StudentRepository repository, AuthUtil authUtil) {
        this.repository = repository;
        this.authUtil = authUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        logger.info("Incoming Request: " + request.getRequestURL());

        final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println("Header: " + requestTokenHeader);

        if(requestTokenHeader == null || !requestTokenHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = requestTokenHeader.split("Bearer ")[1];
        System.out.println("Received token: " + token);
        String username = authUtil.getUsernameFromToken(token);
        System.out.println("Username: " + username);


        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            StudentEntity user = repository.findByName(username).orElseThrow();

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, null);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request, response);
    }
}
