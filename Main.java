<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Interactividad con JavaScript</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    #contenido {
      display: none;
      color: blue;
      margin-top: 10px;
    }
  </style>
</head>
<body>

  <h2>Formulario con Validación</h2>
  <form id="miFormulario">
    <label>Nombre:</label>
    <input type="text" id="nombre" /><br><br>

    <label>Correo:</label>
    <input type="email" id="correo" /><br><br>

    <button type="submit">Enviar</button>
  </form>

  <hr>

  <h2>Botón con Evento Dinámico</h2>
  <button onclick="toggleContenido()">Mostrar/Ocultar Contenido</button>
  <p id="contenido">¡Hola! Este es el contenido oculto que se puede mostrar o esconder.</p>

  <script>
    // Validación del formulario
    document.getElementById("miFormulario").addEventListener("submit", function(event) {
      event.preventDefault(); // Previene el envío del formulario

      const nombre = document.getElementById("nombre").value.trim();
      const correo = document.getElementById("correo").value.trim();

      if (nombre.length <= 3) {
        alert("El nombre debe tener más de 3 caracteres.");
        return;
      }

      if (correo === "") {
        alert("El correo no puede estar vacío.");
        return;
      }

      alert("Formulario válido. ¡Enviado!");
    });

    // Función del botón dinámico
    function toggleContenido() {
      const contenido = document.getElementById("contenido");

      if (contenido.style.display === "none") {
        contenido.style.display = "block";
        contenido.style.color = "green";
        alert("Contenido mostrado.");
      } else {
        contenido.style.display = "none";
        alert("Contenido oculto.");
      }
    }
  </script>

</body>
</html>
