<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
    <jsp:include page="../commons/head.jsp"/>
    <title>Document</title>
</head>
<body>
<div class="modal fade" id="agregarClienteModal" tabindex="-1" aria-labelledby="agregarClienteLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="agregarClienteLabel">Agregar Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/cliente-controller?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group mb-3">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="t.id">tipo de identificacion:</label>
                        <select class="form-select" name="t.id" id="t.id" required>
                            <option value="Tarjeta de identidad">Tarjeta de identidad</option>
                            <option value="Cedula de ciudadania" selected>Cedula de ciudadania</option>
                            <option value="Cedula de extrangero">Cedula de extrangero</option>
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        <label for="n.id">Numero de identificacion:</label>
                        <input type="number" class="form-control" id="n.id" name="n.id" required />
                    </div>
                    <div class="form-group mb-3">
                        <label for="f.nacimiento">Fecha de nacimiento</label>
                        <input type="date" class="form-control" id="f.nacimiento" name="f.nacimiento" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="genero">Genero:</label>
                        <select class="form-select" name="genero" id="genero" required>
                            <option value="Masculino" selected>Masculino</option>
                            <option value="Femenino">Femenino</option>
                            <option value="No binario">No binario</option>
                            <option value="otro">Otro</option>
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        <label for="telefono">Telefono</label>
                        <input type="tel" class="form-control" id="telefono" name="telefono" required />
                    </div>
                    <div class="form-group mb-3">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="direccion">direccion:</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="habitacion">Habitacion:</label>
                        <select name="habitacion" id="habitacion" class="form-select" required>
                            <c:forEach var="habitacion" items="${habitaciones}">
                                <option value="${habitacion.id_habitacion}"> Habitacion ${habitacion.numeroHabitacion}, ${habitacion.tipo}: ${habitacion.estado}</option>
                            </c:forEach>
                        </select>
                    </div>

                </div>
                <!--Pie pagina de la ventana modal-->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>