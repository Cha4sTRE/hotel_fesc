package cj.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import cj.datos.ClienteDAO;
import cj.datos.HabitacionesDAO;
import cj.models.Cliente;
import cj.models.Habitaciones;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "HabitacionesServlet", urlPatterns = {"/habitaciones-controller"})
public class HabitacionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion= Optional.ofNullable(request.getParameter("accion")).orElse("listar");
        String ir=Optional.ofNullable(request.getParameter("ir")).orElse("listar");;
        switch (accion){
            case "listar"->listarHabitaciones(request,response);
            case "eliminarHabitacion"->eliminarHabitacion(request,response);
        }
        if(ir.equals("listar")) this.listarHabitaciones(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion= Optional.ofNullable(request.getParameter("accion")).orElse("listar");

        switch (accion){
            case "insertar"->insertarHabitacion(request,response);

        }

    }

    private void listarHabitaciones(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        List<Habitaciones> habitaciones= new HabitacionesDAO().listarHabitaciones();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("habitaciones",habitaciones);
        String listarHabitaciones = "WEB-INF/pages/habitaciones/listarHabitaciones.jsp";
        request.getRequestDispatcher(listarHabitaciones).forward(request,response);

    }
    private void insertarHabitacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        int numHabitacion=Integer.parseInt(request.getParameter("numHabitacion"));
        String tipo=request.getParameter("tipo");
        String estado=request.getParameter("estado");
        String descripcion=request.getParameter("descripcion");
        int cmax=Integer.parseInt(request.getParameter("cmax"));
        Habitaciones habitacionNueva= new Habitaciones(numHabitacion, tipo, estado, descripcion, cmax);
        new HabitacionesDAO().insertar(habitacionNueva);

        this.listarHabitaciones(request,response);

    }
    private void eliminarHabitacion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        int idHabitacion=Integer.parseInt(request.getParameter("idHabitacion"));
        Habitaciones habitacionEliminar= new Habitaciones(idHabitacion);
        new HabitacionesDAO().eliminarHabitacion(habitacionEliminar);


    }
}