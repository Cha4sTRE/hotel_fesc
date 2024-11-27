<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="es">
<head>
    <jsp:include page="../commons/head.jsp"/>
    <title>Document</title>
</head>
<body>
<div class="modal fade" id="agregarHabitacionModal" tabindex="-1" aria-labelledby="agregarHabitacionLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title" id="agregarClienteLabel">Agregar habitacion</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/habitaciones-controller?accion=insertar"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group mb-3">
                        <label for="nombre">numero de habitacion</label>
                        <input type="text" class="form-control" id="nombre" name="numHabitacion" required/>
                    </div>
                    <div class="form-group mb-3">
                        <label for="tipo">tipo</label>
                        <select class="form-select" name="tipo" id="tipo" required>
                            <option value="doble">doble</option>
                            <option value="simple" selected>simple(1 cama)</option>
                            <option value="vip">VIP</option>
                            <option value="suite">suite</option>
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        <label for="t.id">estado:</label>
                        <select class="form-select" name="estado" id="t.id" required>
                            <option value="disponible">disponible</option>
                            <option value="ocupado" selected>ocupado</option>
                            <option value="arreglos">arreglos</option>
                        </select>
                    </div>
                    <div class="form-group mb-3">
                        <label for="descripcion">descripcion:</label><br>
                        <textarea name="descripcion" id="descripcion" rows="6"></textarea>
                    </div>
                    <div class="form-group mb-3">
                        <label for="max">capacidad maxima: </label>
                        <input type="number" class="form-control" id="max" name="cmax" required/>
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