package servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

public class app {
    public static void main(String[] args) {
        Punto p = new Punto(5, 7);
        BiciUsuario b = new BiciUsuario(1, "", "", "", "", "", "", "", "");
        Alarma a = new Alarma(1, p, b, true);

        Punto p1 = new Punto(5, 7);
        BiciUsuario b1 = new BiciUsuario(1, "", "", "", "", "", "", "", "");
        Alarma a1 = new Alarma(1, p1, b1, true);

        Punto p2 = new Punto(5, 7);
        BiciUsuario b2 = new BiciUsuario(1, "", "", "", "", "", "", "", "");
        Alarma a2 = new Alarma(1, p2, b2, true);

        Alarma[] as = new Alarma[3];
        as[0]=a;
        as[1]=a1;
        as[2]=a2;

        Hospital hos = new Hospital(1, "suba", "s@gmail.com", "123");
        hos.add(a);
        hos.add(a1);
        hos.add(a2);

        List<AlarmaJson> objList = new ArrayList<AlarmaJson>();
        for (int i = 0; i < hos.getAlarmas().tamano(); i++) {
            Alarma ass = ((Alarma) hos.getChild(i));
            Punto pun = ass.getUbicacion();
            BiciUsuario bic = ass.getUsuario();
            AlarmaJson s = new AlarmaJson(pun.getLatitud(), pun.getLongitud(), bic.getNombre(), bic.getApellido(), ass.getActiva());
            objList.add(s);
        }
        // Convert the object to a JSON string
        String json = new Gson().toJson(objList);
        System.out.println(json);
    }
}
