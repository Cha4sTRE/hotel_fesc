<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
    <jsp:include page="../commons/head.jsp"/>
    <title>Document</title>
</head>
<body>
<jsp:include page="../commons/navbar.jsp"/>
<section id="actions" class="py-4 mb-1 mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <button type="button" class="btn btn-primary btn-block w-100" data-bs-toggle="modal" data-bs-target="#agregarHabitacionModal">
                    <i class="bi bi-plus-circle"></i>  agregar habitacion
                </button>
            </div>
        </div>
    </div>
</section>
<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>lista de habitaciones</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <td>numero</td>
                            <td>tipo</td>
                            <td>estado</td>
                            <td>descripcion</td>
                            <td>capacidad maxima</td>
                            <td>acciones</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="habitacion" items="${habitaciones}" varStatus="status">
                            <tr>
                                <td>${status.count}</td>
                                <td>${habitacion.numeroHabitacion}</td>
                                <td>${habitacion.tipo}</td>
                                <td>${habitacion.descripcion}</td>
                                <td>${habitacion.capacidadMax}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/habitaciones-controller?accion=eliminarHabitacion&idHabitacion=${habitacion.id_habitacion}&&ir=listar" class="btn btn-danger btn-sm">
                                        <i class="bi bi-trash"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>

    </div>
</section>
<jsp:include page="../commons/footer.jsp"/>
<jsp:include page="agregarHabitacion.jsp"/>
</body>
</html>