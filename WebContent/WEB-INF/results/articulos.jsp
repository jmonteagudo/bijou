<TABLE BORDER=1 ALIGN="CENTER">
  <TR><TH CLASS="COLORED">Codigo
      <TH CLASS="COLORED">Descripci�n
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