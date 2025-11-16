package com.universidad.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/api/carreras")
public class CarrerasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Habilitar CORS para que React pueda conectarse sin error
        response.setHeader("Access-Control-Allow-Origin", "*");

        JSONArray carreras = new JSONArray();

        JSONObject carrera1 = new JSONObject();
        carrera1.put("nombre", "Ingeniería en Sistemas");
        carrera1.put("duracion", "8 semestres");

        JSONObject carrera2 = new JSONObject();
        carrera2.put("nombre", "Administración de Empresas");
        carrera2.put("duracion", "9 semestres");

        JSONObject carrera3 = new JSONObject();
        carrera3.put("nombre", "Diseño Gráfico");
        carrera3.put("duracion", "8 semestres");

        carreras.put(carrera1);
        carreras.put(carrera2);
        carreras.put(carrera3);

        PrintWriter out = response.getWriter();
        out.print(carreras.toString());
        out.flush();
    }
}
