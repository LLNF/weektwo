import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/***
 * servlet 实现跳转jsp页面
 */

@WebServlet(urlPatterns = "/myservlet1")
public class MyServlet extends HttpServlet {
        @Override
        public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
}
