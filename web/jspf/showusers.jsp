<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div align="justify">
    <div class="container">
        <div class="row-fluid">
            <div class="span7 well">
                <b><font color="blue">Администраторы</font></b><br/>
                <a href="Controller?action=adduserpage&newrole=administrator">Добавить</a>
                <c:if test="${listadministrators[0] != null}">
                    <table class="table">
                        <tr>
                            <td><b>Логин</b></td>
                            <td><b>ФИО</b></td>
                            <td><b>Действие</b></td>
                        </tr>
                        <c:forEach var="it" items="${listadministrators}">
                            <tr>
                                <td><c:out value="${it[0]}"/></td>
                                <td><c:out value="${it[1]}"/></td>
                                <td>
                                    <c:if test="${sessionScope.login != it[0]}">
                                        <a href="Controller?action=removeuser&userlogin=${it[0]}">Удалить</a>
                                    </c:if>
                                    <a href="Controller?action=edituser&userlogin=${it[0]}">Править</a>
                                    <a href="Controller?action=infouser&userlogin=${it[0]}">Подробнее</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${listadministrators[0]==null}">
                    <br/><i>Пользователи этой категории не найдены</i><br/><br/>
                </c:if>
                <b><font color="blue">Мастера</font></b><br/>
                <a href="Controller?action=adduserpage&newrole=master">Добавить</a>
                <c:if test="${listmasters[0] != null}">
                    <table class="table">
                        <tr>
                            <td><b>Логин</b></td>
                            <td><b>ФИО</b></td>
                            <td><b>Действие</b></td>
                        </tr>
                        <c:forEach var="it" items="${listmasters}">
                            <tr>
                                <td><c:out value="${it[0]}"/></td>
                                <td><c:out value="${it[1]}"/></td>
                                <td><a href="Controller?action=removeuser&userlogin=${it[0]}">Удалить</a>
                                    <a href="Controller?action=edituser&userlogin=${it[0]}">Править</a>
                                    <a href="Controller?action=infouser&userlogin=${it[0]}">Подробнее</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${listmasters[0]==null}">
                    <br/><i>Пользователи этой категории не найдены</i><br/><br/>
                </c:if>
                <b><font color="blue">Специалисты</font></b><br/>
                <a href="Controller?action=adduserpage&newrole=specialist">Добавить</a>
                <c:if test="${listspecialists[0]!=null}">
                    <table class="table">
                        <tr>
                            <td><b>Логин</b></td>
                            <td><b>ФИО</b></td>
                            <td><b>Действие</b></td>
                        </tr>
                        <c:forEach var="it" items="${listspecialists}">
                            <tr>
                                <td><c:out value="${it[0]}"/></td>
                                <td><c:out value="${it[1]}"/></td>
                                <td><a href="Controller?action=removeuser&userlogin=${it[0]}">Удалить</a>
                                    <a href="Controller?action=edituser&userlogin=${it[0]}">Править</a>
                                    <a href="Controller?action=infouser&userlogin=${it[0]}">Подробнее</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${listspecialists[0]==null}">
                    <br/><i>Пользователи этой категории не найдены</i><br/><br/>
                </c:if>
                <b><font color="blue">Клиенты</font></b><br/>
                <a href="Controller?action=adduserpage&newrole=client">Добавить</a>
                <c:if test="${listclients[0]!=null}">
                    <table class="table">
                        <tr>
                            <td><b>Логин</b></td>
                            <td><b>ФИО</b></td>
                            <td><b>Действие</b></td>
                        </tr>
                        <c:forEach var="it" items="${listclients}">
                            <tr>
                                <td><c:out value="${it[0]}"/></td>
                                <td><c:out value="${it[1]}"/></td>
                                <td><a href="Controller?action=removeuser&userlogin=${it[0]}">Удалить</a>
                                    <a href="Controller?action=edituser&userlogin=${it[0]}">Править</a>
                                    <a href="Controller?action=infouser&userlogin=${it[0]}">Подробнее</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <c:if test="${listclients[0]==null}">
                    <br/><i>Пользователи этой категории не найдены</i><br/><br/>
                </c:if>
            </div>
        </div>
    </div>
</div>
