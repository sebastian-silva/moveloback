package servlet;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(
    name = "MyServletLogin", 
    urlPatterns = {"/Loginusu"}
)

public class servletLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        Proxy proxy = Proxy.crearUnicaInstancia();
        String correo = req.getParameter("correo");
        String password = req.getParameter("password");
        float key = proxy.acceso(correo, password);
        
        HashMap<String, String> employeeMap = new HashMap<String,String>();        
        employeeMap.put("correo", correo);
        employeeMap.put("key", key+"");
        Gson gson = new Gson();
        String jsonString = gson.toJson(employeeMap);
        out.println(jsonString);
    }
}