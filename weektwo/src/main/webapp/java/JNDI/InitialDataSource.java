package JNDI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/getConnection")
public class InitialDataSource extends HttpServlet {

    public Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/test");
        Connection conn = dataSource.getConnection();
        return conn;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = getConnection();
            String sql = "select name from  user";
            //  5）获取执行sql的对象Statement类的stmt
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while(rs.next()){
                String name = rs.getString("name");
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
