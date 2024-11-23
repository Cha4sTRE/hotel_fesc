
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary">
    <!-- Container wrapper -->
    <div class="container">

        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarButtonsExample">
            <!-- Left links -->
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <a class="nav-link " href="${pageContext.request.contextPath}/servlet-controller?accion=ingresar"  data-bs-toggle="dropdown" aria-expanded="false">
                    Hotel Fesc
                </a>
            </ul>
            <!-- Left links -->
            <div class="d-flex align-items-center">
                <a href="${pageContext.request.contextPath}/servlet-controller?accion=listar">
                    <button data-mdb-ripple-init type="button" class="btn btn-primary me-3">
                        <i class="bi bi-people"></i>
                        Clientes
                    </button>
                </a>
                <a href="${pageContext.request.contextPath}/servlet-controller?accion=listar">
                    <button data-mdb-ripple-init type="button" class="btn btn-primary me-3">
                        <i class="bi bi-basket2-fill"></i>
                        Restaurante
                    </button>
                </a>
                <a href="${pageContext.request.contextPath}/servlet-controller?accion=listar">
                    <button data-mdb-ripple-init type="button" class="btn btn-primary me-3">
                        <i class="bi bi-house-door-fill"></i>
                        Habitaciones
                    </button>
                </a>
                <a href="${pageContext.request.contextPath}/servlet-controller?accion=salir">
                    <button data-mdb-ripple-init type="button" class="btn btn-danger me-3">
                        <i class="bi bi-door-open-fill"></i>
                        salir
                    </button>
                </a>
            </div>
        </div>
        <!-- Collapsible wrapper -->
    </div>
    <!-- Container wrapper -->
</nav>
<!-- Navbar -->