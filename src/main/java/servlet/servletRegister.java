package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet(
    name = "MyServletRegister", 
    urlPatterns = {"/Regisusu"}
)

public class servletRegister extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        Proxy proxy = Proxy.crearUnicaInstancia();
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String documento = req.getParameter("Documento");
        String fecha = req.getParameter("Fecha");
        String telefono = req.getParameter("Telefono");
        String direccion = req.getParameter("Direccion");
        String correo = req.getParameter("correo");
        String password = req.getParameter("password");
        
        String operacion = "2564823,agregarUsuario,"+nombre+","+apellido+","+documento+","+fecha+","+telefono+","+direccion+","+correo+","+password+",";
        proxy.ejecutarOperaciones(operacion);
        
        
        float key = proxy.acceso(correo, password);
        HashMap<String, String> employeeMap = new HashMap<String,String>();        
        employeeMap.put("correo", correo);
        employeeMap.put("key", key+"");
        Gson gson = new Gson();
        String jsonString = gson.toJson(employeeMap);
        out.println(jsonString);
    }
}