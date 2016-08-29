<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<HTML>
<HEAD><TITLE>Detalle de la Operación</TITLE>
<LINK REL=STYLESHEET
      HREF="./css/JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
  Detalle de la operación.
  <TR>
</TABLE>
<P>
<UL>
  <LI><B>Vendedor:</B> ${vendedor.nombre}
  <LI><B>Comprador:</B> ${comprador.nombre}
</UL>
<TABLE BORDER=1 >
  <TR><TH>Codigo
      <TH>Descripción
      <TH>Color
      <TH>Agregados
      <TH>Precio
      <TH>Cantidad
      <TH>Subtotal
<c:forEach var="articulo" items="${catalogo.articulos }">
	<TR ALIGN="CENTER">
    <TD>${articulo.key.codigo }
    <TD>${articulo.key.descripcion }
    <TD>${articulo.key.color }
    <TD>${articulo.key.agregados }
    <TD>${articulo.key.precioVenta }
    <TD><input type="text" name="cantidad${articulo.key.codigo }" value="0" onchange="modificarCantidad">
    <TD><input type="text" readonly="readonly" name="cantidadDisponible${articulo.key.codigo }" value="0">
    <input type="hidden" name="cantidadDisponible" value="${articulo.value}">
</c:forEach>
</TABLE>
<!--<jsp:include page="articulos.jsp" />-->
</BODY></HTML>