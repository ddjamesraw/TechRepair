package by.bsuir.ddjames.techrepair.controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ControllerFilter implements Filter {
    
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }
   
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        // чтение кодировки из запроса
        String encoding = request.getCharacterEncoding();
        System.out.println(encoding);
        // установка UTF-8, если не установлена
        if (!"UTF-8". equalsIgnoreCase(encoding)) {
            response.setCharacterEncoding("UTF-8");
        }
        next.doFilter(request, response);
    }
    
    @Override
    public void destroy() {}
}
