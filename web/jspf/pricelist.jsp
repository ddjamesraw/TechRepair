<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<div align="justify">
    <div class="container">
        <div class="row-fluid">
           <div class="span7">
                <div class="carousel shadow"> 
                    <div class="carousel-button-left"><a href="#"></a></div> 
                    <div class="carousel-button-right"><a href="#"></a></div> 
                    <div class="carousel-wrapper"> 
                       <div class="carousel-items"> 
                            <div class="carousel-block">
                                <table class="table">
                                    <tr>
                                      <th>№ категории</th>
                                      <th>Описание</th>
                                      <th>Стоимость, бел. руб.</th>
                                    </tr>
                                    <c:forEach items="${pricelist_1}" var="it">
                                        <tr>    
                                          <td><c:out value="${it[2]}" /></td>   
                                          <td><c:out value="${it[0]}" /></td>   
                                          <td><b><c:out value="${it[1]}" /></b></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <div class="carousel-block">
                                <table class="table">
                                    <tr>
                                      <th>№ категории</th>
                                      <th>Описание</th>
                                      <th>Стоимость, бел. руб.</th>
                                    </tr>
                                    <c:forEach items="${pricelist_2}" var="it">
                                        <tr>    
                                          <td><c:out value="${it[2]}" /></td>   
                                          <td><c:out value="${it[0]}" /></td>   
                                          <td><b><c:out value="${it[1]}" /></b></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <div class="carousel-block">
                                <table class="table">
                                    <tr>
                                      <th>№ категории</th>
                                      <th>Описание</th>
                                      <th>Стоимость, бел. руб.</th>
                                    </tr>
                                    <c:forEach items="${pricelist_3}" var="it">
                                        <tr>    
                                          <td><c:out value="${it[2]}" /></td>   
                                          <td><c:out value="${it[0]}" /></td>   
                                          <td><b><c:out value="${it[1]}" /></b></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <div class="carousel-block">
                                <table class="table">
                                    <tr>
                                      <th>№ категории</th>
                                      <th>Описание</th>
                                      <th>Стоимость, бел. руб.</th>
                                    </tr>
                                    <c:forEach items="${pricelist_4}" var="it">
                                        <tr>    
                                          <td><c:out value="${it[2]}" /></td>   
                                          <td><c:out value="${it[0]}" /></td>   
                                          <td><b><c:out value="${it[1]}" /></b></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
