<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>

	<h1>Lista de Produtos cadastrados:</h1>
	<p> ${sucesso} </p>
	<table>
        <tr>
            <td>Título</td>
            <td>Descrição</td>
            <td>Páginas</td>
            </td>
        </tr>
        
        <c:forEach items="${produtos}" var="produto">
        	<tr>
        		<td><a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a></td>
        		<td>${produto.descricao}</td>
        		<td>${produto.paginas}</td>
        	</tr>
        </c:forEach>
        
    </table>
	
	
</body>
</html>