<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Compras</TITLE>
<LINK REL=STYLESHEET
      HREF="./css/JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<TABLE BORDER=5 ALIGN="CENTER">
  <TR><TH CLASS="TITLE">
  Compras
</TABLE>
<P>
<form action="compras" enctype="multipart/form-data" method="POST">
<input type="hidden" name="accion" value="${accion}">
Año:<input type="text" name="anio">
Mes:<input type="text" name="mes"><BR><br>
<input  type="file" name="file" id="file"><br><br><br>
<input type="submit" value="Procesar">
</form>
</body></html>