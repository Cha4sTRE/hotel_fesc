<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="../commons/head.jsp"/>
    <title>Editar Cliente</title>
</head>
<body>

<jsp:include page="../commons/navbar.jsp"/>

<form action="${pageContext.request.contextPath}/servlet-controller?accion=modificar&&idCliente=${cliente.id_cliente}&&ir=listar" method="post" class="was-validated">

    <div class="container my-4">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h4>Editar cliente</h4>
            </div>
            <div class="card-body">
                <div class="form-group mb-3">
                    <label for="nombre">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${cliente.nombre}" required/>
                </div>
                <div class="form-group mb-3">
                    <label for="apellido">Apellido</label>
                    <input type="text" class="form-control" id="apellido" name="apellido" value="${cliente.apellido}" required/>
                </div>
                <div class="form-group mb-3">
                    <label for="t.id">tipo de identificacion:</label>
                    <select class="form-select" name="t.id" id="t.id" required>
                        <option value="Tarjeta de identidad" <c:out value="${(cliente.tipoIdentificacion=='Tarjeta de identidad')?'selected':''}"/>>Tarjeta de identidad</option>
                        <option value="Cedula de ciudadania"  <c:out value="${(cliente.tipoIdentificacion=='Cedula de ciudadania')?'selected':''}"/> >Cedula de ciudadania</option>
                        <option value="Cedula de extrangero"  <c:out value="${(cliente.tipoIdentificacion=='Cedula de extrangero')?'selected':''}"/> >Cedula de extrangero</option>
                    </select>
                </div>
                <div class="form-group mb-3">
                    <label for="n.id">Numero de identificacion:</label>
                    <input type="number" class="form-control" id="n.id" name="n.id" value="${cliente.numeroIdentificacion}" required />
                </div>
                <div class="form-group mb-3">
                    <label for="f.nacimiento">Fecha de nacimiento</label>
                    <input type="date" class="form-control" id="f.nacimiento" name="f.nacimiento" value="${cliente.fechaNacimiento}" required/>
                </div>
                <div class="form-group mb-3">
                    <label for="genero">Genero:</label>
                    <select class="form-select" name="genero" id="genero" required>
                        <option value="Masculino" <c:out value="${(cliente.genero=='Masculino'?'selected':'')}"/>>Masculino</option>
                        <option value="Femenino"  <c:out value="${(cliente.genero=='Femenino'?'selected':'')}"/> >Femenino</option>
                        <option value="No binario"  <c:out value="${(cliente.genero=='No binario'?'selected':'')}"/> >No binario</option>
                        <option value="otro"  <c:out value="${(cliente.genero=='otro'?'selected':'')}"/> >Otro</option>
                    </select>
                </div>
                <div class="form-group mb-3">
                    <label for="telefono">Telefono</label>
                    <input type="tel" class="form-control" id="telefono" name="telefono" value="${cliente.telefono}" required />
                </div>
                <div class="form-group mb-3">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" value="${cliente.correoElectronico}" required/>
                </div>
                <div class="form-group mb-3">
                    <label for="direccion">direccion</label>
                    <input type="text" class="form-control" id="direccion" name="direccion" value="${cliente.direccion}" required/>
                </div>
        </div>
    </div>
        <section id="accionesEditar" class="py-4 mb-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <a href="${pageContext.request.contextPath}/servlet-controller?accion=listar" class="btn btn-secondary btn-block w-100">
                            <i class="bi bi-arrow-left"></i> Regresar
                        </a>
                    </div>
                    <div class="col-md-3">
                        <button type="submit" class="btn btn-success btn-block w-100">
                            <i class="bi bi-check-lg"></i> Guardar Cliente
                        </button>
                    </div>
                </div>
            </div>
        </section>
    </div>
</form>


</body>
</html>