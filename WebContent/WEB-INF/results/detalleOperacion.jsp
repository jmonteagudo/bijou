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
  <LI><B>Fecha de la operación:</B> ${operacion.fecha}
  <LI><B>Descuento:</B> ${operacion.descuento}
</UL>
<TABLE BORDER=1 >
  <TR><TH CLASS="COLORED">Codigo
      <TH CLASS="COLORED">Descripción
      <TH>Color
      <TH>Agregados
      <TH>Precio
      <TH>Cantidad
      <TH>Subtotal
<c:forEach var="articulo" items="${operacion.articulos }">
	<TR ALIGN="CENTER">
    <TD>${articulo.key.codigo }
    <TD>${articulo.key.descripcion }
    <TD>${articulo.key.color }
    <TD>${articulo.key.agregados }
    <TD>${articulo.key.precioCompra }
    <TD>${articulo.value }
    <TD>${articulo.value * articulo.key.precioCompra }  
</c:forEach>
</TABLE>
<!--<jsp:include page="articulos.jsp" />-->
</BODY></HTML>