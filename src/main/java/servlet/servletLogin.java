package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "MyServletLogin", 
    urlPatterns = {"/adicionarusu"}
)

public class servletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        Proxy proxy = Proxy.crearUnicaInstancia();
        proxy.addBiciUsuario("sebas", "123");
        String correo = req.getParameter("correo");
        String password = req.getParameter("password");
        float key = proxy.acceso(correo, password);
        out.println(""+key);
        PrintWriter outs = resp.getWriter();
        outs.println("Hello World");
        outs.println("entramos");
    }
}

