<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <jsp:include page="WEB-INF/pages/commons/head.jsp"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .hero {
            background-image: url(https://www.theressa.net/images/projects/592356c2d4ac8hotel-el-pardo-remodelacion-fachada-00.jpg); /* Cambia esta URL por la imagen de tu hotel */
            background-size: cover;
            background-position: center;
            height: 70vh;
            color: #000;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
        }
        .section {
            padding: 60px 0;
        }
    </style>
</head>
<body>
    <jsp:include page="WEB-INF/pages/commons/navbar.jsp"/>

    <!-- Sección Hero -->
    <header class="hero">
        <div class="container">
            <h1 class="display-4">Bienvenido a Nuestro Hotel</h1>
            <p class="lead">La mejor experiencia en alojamiento y servicios personalizados.</p>
            <a href="#services" class="btn btn-light btn-lg">Descubre Nuestros Servicios</a>
        </div>
    </header>

    <!-- Sección Acerca de -->
    <section class="section bg-light" id="about">
        <div class="container">
            <h2 class="text-center">¿Qué es nuestro software?</h2>
            <p class="text-center">Nuestro software de gestión hotelera está diseñado para facilitar la administración de clientes y servicios, optimizando la experiencia tanto para el personal como para los huéspedes.</p>
        </div>
    </section>

    <!-- Sección Servicios -->
    <section class="section" id="services">
        <div class="container">
            <h2 class="text-center">Nuestros Servicios</h2>
            <div class="row">
                <div class="col-md-4 text-center">
                    <h3>Reservas Online</h3>
                    <p>Facilita a tus clientes realizar reservas de manera rápida y sencilla.</p>
                </div>
                <div class="col-md-4 text-center">
                    <h3>Atención al Cliente</h3>
                    <p>Soporte 24/7 para resolver cualquier duda o inconveniente.</p>
                </div>
                <div class="col-md-4 text-center">
                    <h3>Gestión de Habitaciones</h3>
                    <p>Control total sobre la disponibilidad y estado de las habitaciones.</p>
                </div>
            </div>
        </div>
    </section>

    <!-- Sección Características -->
    <section class="section bg-light" id="features">
        <div class="container">
            <h2 class="text-center">Características del Software</h2>
            <ul class="list-group">
                <li class="list-group-item">Interfaz amigable y fácil de usar.</li>
                <li class="list-group-item">Informes detallados sobre ocupación y ventas.</li>
                <li class="list-group-item">Integración con plataformas de pago.</li>
                <li class="list-group-item">Acceso remoto desde cualquier dispositivo.</li>
                <li class="list-group-item">Actualizaciones automáticas y soporte técnico.</li>
            </ul>
        </div>
    </section>

    <!-- Sección Contacto -->
    <section class="section" id="contact">
        <div class="container">
            <h2 class="text-center">Contáctanos</h2>
            <form>
                <div class="form-group">
                    <label for="name">Nombre</label>
                    <input type="text" class="form-control" id="name" placeholder="Tu nombre">
                </div>
                <div class="form-group">
                    <label for="email">Correo Electrónico</label>
                    <input type="email" class="form-control" id="email" placeholder="Tu correo">
                </div>
                <div class="form-group">
                    <label for="message">Mensaje</label>
                    <textarea class="form-control" id="message" rows="3" placeholder="Tu mensaje"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </section>
</body>
</html>