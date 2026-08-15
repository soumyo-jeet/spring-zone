package in.soumyo.CRUDSpringBoot.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        long startTime = System.currentTimeMillis();

        // request and response casting
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String reqId = UUID.randomUUID().toString();

        httpResponse.setHeader("X-Request-ID", reqId);

        System.out.println("Request coming( " + reqId + " ): " + httpRequest.getMethod() +
                " to " + httpRequest.getRequestURI());

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Request exiting with: " + httpResponse.getStatus() + " status");
        System.out.println("Response time: " + duration);
    }
}
