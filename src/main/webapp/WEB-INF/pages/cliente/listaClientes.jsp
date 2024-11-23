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
                <button type="button" class="btn btn-primary btn-block w-100" data-bs-toggle="modal" data-bs-target="#agregarClienteModal">
                    <i class="bi bi-plus-circle"></i>  agregar cliente
                </button>
            </div>
        </div>
    </div>
</section>
<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <h4>lista de clientes</h4>
                    </div>
                    <table class="table table-striped table-sm">
                        <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>nombre</th>
                            <th>tipo de documento</th>
                            <th>numero de documento</th>
                            <th>Fecha de nacimiento</th>
                            <th>genero</th>
                            <th>telefono</th>
                            <th>correo</th>
                            <th>direccion</th>
                            <th>Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                         <c:forEach var="cliente" items="${clientes}" varStatus="status">
                             <tr>
                                 <td>${status.count}</td>
                                 <td>${cliente.nombre} ${cliente.apellido}</td>
                                 <td>${cliente.tipoIdentificacion}</td>
                                 <td>${cliente.numeroIdentificacion}</td>
                                 <td>${cliente.fechaNacimiento}</td>
                                 <td>${cliente.genero}</td>
                                 <td>${cliente.telefono}</td>
                                 <td>${cliente.correoElectronico}</td>
                                 <td>${cliente.direccion}</td>
                                 <td>
                                     <a href="${pageContext.request.contextPath}/servlet-controller?accion=editar&idCliente=${cliente.id_cliente}" class="btn btn-secondary btn-sm">
                                         <i class="bi bi-pencil"></i>
                                     </a>
                                     <a href="${pageContext.request.contextPath}/servlet-controller?accion=eliminar&idCliente=${cliente.id_cliente}&&ir=listar" class="btn btn-danger btn-sm">
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
<jsp:include page="agregarCliente.jsp"/>
</body>
</html>