import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter("/FilterDemoServlet")
public class FilterServlet extends HttpFilter implements Filter {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void destroy() {
        // Placeholder
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            response.getWriter().print("Pre Servlet - Filter");
        } catch (IOException e) {
            e.printStackTrace();
        }

        chain.doFilter(request, response);
        response.getWriter().print("Pre Servlet - Filter");
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // Placeholder
    }

}
