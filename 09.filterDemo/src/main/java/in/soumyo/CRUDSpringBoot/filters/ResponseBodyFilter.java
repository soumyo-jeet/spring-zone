package in.soumyo.CRUDSpringBoot.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        ContentCachingResponseWrapper wrappedResponse =
                new ContentCachingResponseWrapper(httpResponse);

        chain.doFilter(request, wrappedResponse);

        byte[] bodyByte = wrappedResponse.getContentAsByteArray();
        String bodyString = new String(bodyByte);

        String respString =
                """
                {
                    "originalResponse" : %s,
                    "app" : "Student Management Site"
                }
                """.formatted(bodyString);

        wrappedResponse.resetBuffer();
        wrappedResponse.getWriter().write(respString);
        wrappedResponse.copyBodyToResponse();
    }
}
