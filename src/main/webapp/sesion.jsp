<!doctype html>
<html lang="es">
<head>
    <jsp:include page="WEB-INF/pages/commons/head.jsp"/>
    <title>Document</title>

</head >
<body>

<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card bg-dark text-white" style="border-radius: 1rem;">
                    <div class="card-body p-5r">
                        <form action="${pageContext.request.contextPath}/servlet-controller?accion=ingresar" method="post">
                            <div class="mb-md-5 mt-md-4 pb-5">
                                <h2 class="fw-bold mb-2 text-uppercase text-center">Login</h2>

                                <div data-mdb-input-init class="form-inline form-white mb-4 mt-4">
                                    <label class="form-label" for="typeEmailX">Username</label>
                                    <input type="text" id="typeEmailX" class="form-control form-control-lg" name="username" />
                                </div>

                                <div data-mdb-input-init class="form-outline form-white mb-4">
                                    <label class="form-label" for="typePasswordX">Password</label>
                                    <input type="password" id="typePasswordX" class="form-control form-control-lg" name="password" />
                                </div>
                                <div class="text-center">
                                    <button data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-light btn-lg px-5 " type="submit">entrar</button>
                                </div>

                            </div>
                        </form>



                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


</body>
</html>