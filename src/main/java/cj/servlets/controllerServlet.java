package cj.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import cj.datos.AdminDAO;
import cj.datos.ClienteDAO;
import cj.models.Admin;
import cj.models.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "controllerServlet", urlPatterns = {"/servlet-controller"})
public class controllerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String accion= Optional.ofNullable(request.getParameter("accion")).orElse("ingresar");
        String ir=Optional.ofNullable(request.getParameter("ir")).orElse("ingresar");
        switch(accion){
            case "ingresar"->this.inicioSesion(request, response);
            case "salir"->cerrarsesion(request,response);
            case "listar"->this.listarClientes(request,response);
            case "editar"->this.editarCliente(request,response);
            case "eliminar"->this.eliminarCliente(request,response);
            default->this.inicioSesion(request,response);
        }
        if(ir.equals("listar")) this.listarClientes(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String accion= Optional.ofNullable(request.getParameter("accion")).orElse("ingresar");
        String ir=Optional.ofNullable(request.getParameter("ir")).orElse("ingresar");;
        switch(accion){
            case "ingresar"->this.inicioSesion(request,response);
            case "insertar"->this.insertarCliente(request,response);
            case "modificar" ->this.modificarCliente(request,response);
            default->this.listarClientes(request,response);
        }
        if(ir.equals("listar")) this.listarClientes(request,response);

    }

    private void inicioSesion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Obtener parámetros del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Validar credenciales
        Admin admin = new AdminDAO().adminSesion(new Admin(username, password));

        // Credenciales válidas
        HttpSession session = request.getSession();
        session.setAttribute("admin", admin); // Guardar el administrador en la sesión
        if (admin != null && admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            request.getRequestDispatcher("dashboard.jsp").forward(request,response); // Redirigir al dashboard
            System.out.println("Usuario y contraseña correctos.");

        }else if(session != null && session.getAttribute("admin") != null){

            // Usuario autenticado, redirigir al dashboard
            RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
            dispatcher.forward(request, response);

        }
        else{
            // Credenciales inválidas
            request.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("sesion.jsp").forward(request, response);
        }
    }
    private void cerrarsesion(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // Invalidar la sesión
        HttpSession session = request.getSession(false); // Evita crear una nueva sesión si no existe
        if (session != null) {
            session.invalidate(); // Invalida la sesión existente
        }
        // Redirigir al inicio de sesión
        response.sendRedirect("sesion.jsp");
    }
    private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Cliente> clientes= new ClienteDAO().listarClientes();
        HttpSession sesion=request.getSession();
        sesion.setAttribute("clientes",clientes);
        String listaClientes = "WEB-INF/pages/cliente/listaClientes.jsp";
        request.getRequestDispatcher(listaClientes).forward(request,response);

    }
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String tc= request.getParameter("t.id");
        long ni=Long.parseLong(request.getParameter("n.id"));
        String fechaN= request.getParameter("f.nacimiento");
        String genero= request.getParameter("genero");
        long telefono= Long.parseLong(request.getParameter("telefono"));
        String email= request.getParameter("email");
        String direccion= request.getParameter("direccion");

        Cliente nuevoCliente= new Cliente(nombre,apellido,tc,ni,fechaN,genero,telefono,email,direccion);
        new ClienteDAO().insertar(nuevoCliente);
        this.listarClientes(request, response);

    }
    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int idCliente= Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente= new ClienteDAO().encontrarCliente(new Cliente(idCliente));
        request.setAttribute("cliente",cliente);
        String jspEdit="WEB-INF/pages/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEdit).forward(request,response);

    }
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response){
        int idCliente= Integer.parseInt(request.getParameter("idCliente"));
        String nombre= request.getParameter("nombre");
        String apellido= request.getParameter("apellido");
        String tc= request.getParameter("t.id");
        long ni=Long.parseLong(request.getParameter("n.id"));
        String fechaN= request.getParameter("f.nacimiento");
        String genero= request.getParameter("genero");
        long telefono= Long.parseLong(request.getParameter("telefono"));
        String email= request.getParameter("email");
        String direccion= request.getParameter("direccion");

        Cliente cliente=new Cliente(idCliente,nombre,apellido,tc,ni,fechaN,genero,telefono,email,direccion);
        new ClienteDAO().actualizar(cliente);
    }
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response){

        int idCliente= Integer.parseInt(request.getParameter("idCliente"));
        Cliente clienteAEliminar= new Cliente(idCliente);
        new ClienteDAO().eliminarCliente(clienteAEliminar);

    }
}