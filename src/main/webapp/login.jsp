<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>

<h1>Login de usuario</h1>
<div>
    <form action="/cookiss/login" method="post">
        <div>
            <lable for="username">Nombre de usuario que desea Ingresar:</lable>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>

        <div>
            <lable for="pass">Contraseña del usuario que desea Ingresar:</lable>
            <div>

                <input type="password" name="password" id="pass">
            </div>
        </div>
        <div>
            <br>
            <input type="submit" value="Enviar">
        </div>

    </form>
</div>

</body>
</html>