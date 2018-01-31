<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entities.Jugador" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jugadores</title>
</head>
<body>
	<%
			Jugador j = (Jugador)session.getAttribute("jug");		
	%>
	<form method="post" action="ABMJugador">
	<h2>Menu jugadores</h2>
	<br>
	<label>Nombre</label>
	<input name="nombreJugador" type="text" <% 
		if(j != null){
			%> value="<%=j.getNombre()%> "<%
		}else{
			%>value=""<%
		}
	%>>
	<label>Apellido</label>
	<input name="apellidoJugador" type="text" <% 
		if(j != null){
			%> value="<%=j.getApellido()%> "<%
		}else{
			%>value=""<%
		}
	%>>
	<label>Posicion</label>
	<select name="posicion">
		<option value=""></option>
		<option value="arquero">Arquero</option>
		<option value="defensor">Defensor</option>
		<option value="mediocampista">Mediocampista</option>
		<option value="delantero">Delantero</option>
	</select>
	<label>Equipo</label>
	<!-- TODAVIA NO IMPLEMENTADO: aca traer de la BD los equipos cargados para mostrarlos en un dropdown -->
	<div class="acciones">
		<button name="agregar" type="submit">Agregar</button>
		<button name="modificar" type="submit">Modificar</button>
		<button name="borrar" type="submit">Borrar</button>
	</div>
	</form>
</body>
</html>