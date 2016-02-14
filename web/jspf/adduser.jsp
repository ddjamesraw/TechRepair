<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div align="justify">
    <div class="container">
        <div class="row-fluid">
            <div class="span7 well" align="center">
                <c:if test="${newuserrole eq 'administrator'}">
                    <legend>Новый администратор</legend>
                    <form method="POST" action="Controller" accept-charset="UTF-8">
                        <input type="hidden" name="action" value="adduser"/>
                        <input type="hidden" name="newuserrole" value="administrator"/>
                        <input type="text" name="newuserlogin" placeholder="Логин" required/><br/>
                        <input type="password" name="newuserpassword" placeholder="Пароль" required/><br/>
                        <input type="password" name="newuserpassword2" placeholder="Повторите пароль" required/><br/>
                        <input type="text" name="newuserfio" placeholder="Ф.И.О." required/><br/>
                        <input type="text" name="newuserphone" placeholder="Телефон" required/><br/>
                        <button type="submit" name="submit" class="btn btn-info" style="width: 220px;">Создать</button>
                    </form>
                </c:if>
                <c:if test="${newuserrole eq 'master'}">
                    <legend>Новый мастер</legend>
                    <form method="POST" action="Controller" accept-charset="UTF-8">
                        <input type="hidden" name="action" value="adduser"/>
                        <input type="hidden" name="newuserrole" value="master"/>
                        <input type="text" name="newuserlogin" placeholder="Логин" required/><br/>
                        <input type="password" name="newuserpassword" placeholder="Пароль" required/><br/>
                        <input type="password" name="newuserpassword2" placeholder="Повторите пароль" required/><br/>
                        <input type="text" name="newuserfio" placeholder="Ф.И.О." required/><br/>
                        <input type="text" name="newuserphone" placeholder="Телефон" required/><br/>
                        <button type="submit" name="submit" class="btn btn-info" style="width: 220px;">Создать</button>
                    </form>
                </c:if>
                <c:if test="${newuserrole eq 'specialist'}">
                    <legend>Новый специалист</legend>
                    <form method="POST" action="Controller" accept-charset="UTF-8">
                        <input type="hidden" name="action" value="adduser"/>
                        <input type="hidden" name="newuserrole" value="specialist"/>
                        <input type="text" name="newuserlogin" placeholder="Логин" required/><br/>
                        <input type="password" name="newuserpassword" placeholder="Пароль" required/><br/>
                        <input type="password" name="newuserpassword2" placeholder="Повторите пароль" required/><br/>
                        <input type="text" name="newuserfio" placeholder="Ф.И.О." required/><br/>
                        <input type="text" name="newuserphone" placeholder="Телефон" required/><br/>
                        <button type="submit" name="submit" class="btn btn-info" style="width: 220px;">Создать</button>
                    </form>
                </c:if>
                <c:if test="${newuserrole eq 'client'}">
                    <legend>Новый клиент</legend>
                    <form method="POST" action="Controller" accept-charset="UTF-8">
                        <input type="hidden" name="action" value="adduser"/>
                        <input type="hidden" name="newuserrole" value="client"/>
                        <input type="text" name="newuserlogin" placeholder="Логин" required/><br/>
                        <input type="password" name="newuserpassword" placeholder="Пароль" required/><br/>
                        <input type="password" name="newuserpassword2" placeholder="Повторите пароль" required/><br/>
                        <input type="text" name="newuserfio" placeholder="Ф.И.О." required/><br/>
                        <input type="text" name="newuserpassport" placeholder="№ паспорта" required/><br/>
                        <input type="text" name="newuseraddress" placeholder="Домашний адрес" required/><br/>
                        <input type="text" name="newuserphone" placeholder="Телефон" required/><br/>
                        <input type="text" name="newuseremail" placeholder="E-mail" required/><br/>
                        <button type="submit" name="submit" class="btn btn-info" style="width: 220px;">Создать</button>
                    </form>
                </c:if>
            </div>
        </div>
    </div>
</div>