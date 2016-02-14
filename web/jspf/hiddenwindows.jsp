<%-- any content can be specified here e.g.: --%>
<%@ page pageEncoding="UTF-8" %>
<div class="span3 well" id="enterWindow">
    <legend>Вход</legend>
        <form method="POST" action="Controller" accept-charset="UTF-8">
            <input type="hidden" name="action" value="login"/>
            <input type="text" id="login" class="span3" name="login" placeholder="Логин" required/>
            <input type="password" id="password" class="span3" name="password" placeholder="Пароль" required/>
            <button type="submit" name="submit" class="btn btn-info btn-block">Войти</button>
        </form>
        <button type="submit" name="submit" class="btn btn-success btn-block" id="buttonCancelEnterWindow">Отмена</button>
</div>
<div class="span3 well" id="exitWindow">
    <legend>Вы уверены?</legend>
    <form method="POST" action="Controller" accept-charset="UTF-8">
        <input type="hidden" name="action" value="logout">
        <button type="submit" name="submit" class="btn btn-success btn-block">Да</button>
        </form>
        <button type="submit" name="submit" class="btn btn-warning btn-block" id="buttonCancelExitWindow">Нет</button>
</div>        
<div class="span3 well" id="newOrderWindow">
    <legend>Новый заказ</legend>
        <form method="POST" action="Controller" accept-charset="UTF-8">
            <input type="hidden" name="action" value="addorder"/>
            <input type="text" id="description" class="span3" name="description" placeholder="Описание" required/>
            Категория:&nbsp;&nbsp;&nbsp;<input type="number" id="category" class="span2" value="1" min="0" name="category" required/>
            Количество:&nbsp;<input type="number" id="count" class="span2" name="count" value="1" min="0" required/><br/>
            Скидка, %:&nbsp;&nbsp;&nbsp;<input type="number" id="discount" class="span2" name="discount" value="0" max="100" min="0" required/>
            <input type="text" id="newlogin" class="span3" name="newlogin" placeholder="Логин" required/>
            <input type="password" id="newpassword" class="span3" name="newpassword" placeholder="Пароль" required/>
            <input type="text" id="fio" class="span3" name="fio" placeholder="ФИО" required=""/>
            <input type="text" id="passport" class="span3" name="passport" placeholder="Номер паспорта" required=""/>
            <input type="text" id="address" class="span3" name="address" placeholder="Домашний адрес"/>
            <input type="text" id="phone" class="span3" name="phone" placeholder="Контактный телефон"/>
            <input type="text" id="email" class="span3" name="email" placeholder="E-mail"/>
            <button type="submit" name="submit" class="btn btn-info btn-block">Создать</button>
        </form>
        <button type="submit" name="submit" class="btn btn-success btn-block" id="buttonCancelNewOrderWindow">Отмена</button>
</div>
<div class="span3 well" id="getStatisticWindow">
    <legend>Параметры</legend>
    <form method="POST" action="Controller" accept-charset="UTF-8">
        <input type="hidden" name="action" value="getstatistic">
        Начало периода:<br/>
        <input type="date" name="datebegin" required /><br/>
        Конец периода:<br/>
        <input type="date" name='dateend' required /><br/>
        <input type="checkbox" name="count_orders" />&nbsp;Общее количество заказов<br/>
        <input type="checkbox" name="count_orders_by_category" />&nbsp;Количество заказов по каждой категории<br/>
        <input type="checkbox" name="count_orders_by_master" />&nbsp;Количество заказов по каждому мастеру<br/>
        <input type="checkbox" name="total_summ">&nbsp;Суммарная стоимость заказов<br/><br/>
        <button type="submit" name="submit" class="btn btn-success btn-block">Отправить</button>
    </form>
    <button type="submit" name="submit" class="btn btn-warning btn-block" id="buttonCancelGetStatisticWindow">Отмена</button>
</div>        
<div id="overlay"></div>