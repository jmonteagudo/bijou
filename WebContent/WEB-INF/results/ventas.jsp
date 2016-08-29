<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Ventas</TITLE>
<LINK REL=STYLESHEET
      HREF="./css/JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
  Ventas
</TABLE>
<P>
<form action="ventas" enctype="multipart/form-data" method="POST">
<input type="hidden" name="accion" value="${accion}">
<UL>
  <LI><B>Revendedor:</B> ${revendedor.nombre}
</UL>
Cliente:<input type="text" name="clienteNombre">
E-Mail:<input type="text" name="clienteEMail">
Catálogo (aaaamm)<input type="text" name="catalogo">
<input type="submit" value="Siguiente">
</form>
</BODY></HTML>