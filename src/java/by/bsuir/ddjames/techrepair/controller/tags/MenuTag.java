package by.bsuir.ddjames.techrepair.controller.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public final class MenuTag extends TagSupport {
    
    private String role;
    private String clientMenu;
    private String specialistMenu;
    private String administratorMenu;
    private String defaultMenu;
      
    @Override
    public int doStartTag () throws JspException {
        String login = "";
        try {
            login =  pageContext.getSession().getAttribute("login").toString();
        } catch(Exception e) {
        }
        try {
            this.role = pageContext.getSession().getAttribute("role").toString();
                if (this.role == null) {
                    this.role = "";
                }
        } catch (Exception e) {
            this.role = "";
        }
        try {
            if(this.role.equals("client")) {
                this.setClientMenu(login);
                pageContext.getOut().write(clientMenu);
            } else {
                if(this.role.equals("specialist")) {
                    this.setSpecialistMenu(login);
                    pageContext.getOut().write(specialistMenu);
                } else {
                    if(this.role.equals("administrator")) {
                        this.setAdministratorMenu(login);
                        pageContext.getOut().write(administratorMenu);
                    } else {
                        this.setDefaultMenu();
                        pageContext.getOut().write(defaultMenu);
                      }
                }
            }
        } catch (IOException e) {}   
        return SKIP_BODY;
    }

    public void setClientMenu(String login) {
        this.clientMenu = "<a class=\"brand\" href=\"Controller?action=gohome\">TechRepair</a>\n" +
            "<ul class=\"nav pull-left\">\n" +
            "    <li><a href=\"Controller?action=pricelist\">Услуги и цены</a></li>\n" +
            "    <li><a href=\"Controller?action=shownews\">Новости IT</a></li>\n" +
            "    <li><a href=\"Controller?action=showcomments\">Отзывы</a></li>\n" +
            "    <li><a href=\"Controller?action=showorders\">Мои заказы</a></li>\n" +
            "</ul>" + 
            "<ul class=\"nav pull-right\">\n" +
            "    <li><a href=\"#\"><font color=\"blue\"><u><b>" + login + "</b></u></font></a></li>" +    
            "    <li><a href=\"#\" id=\"buttonOpenExitWindow\">Выход</a></li>\n" +
            "</ul>";
    }

    public void setSpecialistMenu(String login) {
        this.specialistMenu = "<a class=\"brand\" href=\"Controller?action=gohome\">TechRepair</a>\n" +
            "<ul class=\"nav\">\n" +
            "    <li><a href=\"Controller?action=pricelist\">Услуги и цены</a></li>\n" +
            "    <li><a href=\"Controller?action=shownews\">Новости IT</a></li>\n" +
            "    <li><a href=\"Controller?action=showcomments\">Отзывы</a></li>\n" +
            "    <li><a href=\"#\" id=\"buttonOpenGetStatisticWindow\">Статистика</a></li>\n" +
            "    <li><a href=\"#\" id=\"buttonOpenNewOrderWindow\">Новый заказ</a></li>\n" +
            "</ul>" + 
            "<ul class=\"nav pull-right\">\n" +
            "    <li><a href=\"#\"><font color=\"blue\"><u><b>" + login + "</b></u></font></a></li>" +    
            "    <li><a href=\"#\" id=\"buttonOpenExitWindow\">Выход</a></li>\n" +
            "</ul>";    
    }

    public void setAdministratorMenu(String login) {
        this.administratorMenu = "<a class=\"brand\" href=\"Controller?action=gohome\">TechRepair</a>\n" +
            "<ul class=\"nav pull-left\">\n" +
            "    <li><a href=\"Controller?action=pricelist\">Услуги и цены</a></li>\n" +
            "    <li><a href=\"Controller?action=shownews\">Новости IT</a></li>\n" +
            "    <li><a href=\"Controller?action=showadmincomments\">Отзывы</a></li>\n" +
            "    <li><a href=\"Controller?action=showadminorders\">Заказы</a></li>\n" +
            "    <li><a href=\"Controller?action=showusers\">Пользователи</a></li>\n" +
            "</ul>" +
            "<ul class=\"nav pull-right\">\n" +
            "    <li><a href=\"#\"><font color=\"blue\"><u><b>" + login + "</b></u></font></a></li>" +    
            "    <li><a href=\"#\" id=\"buttonOpenExitWindow\">Выход</a></li>\n" +
            "</ul>";
    }

    public void setDefaultMenu() {
        this.defaultMenu = "<a class=\"brand\" href=\"Controller?action=gohome\">TechRepair</a>\n" +
            "<ul class=\"nav pull-left\">\n" +
            "    <li><a href=\"Controller?action=pricelist\">Услуги и цены</a></li>\n" +
            "    <li><a href=\"Controller?action=shownews\">Новости IT</a></li>\n" +
            "    <li><a href=\"Controller?action=showcomments\">Отзывы</a></li>\n" +
            "</ul>" + 
            "<ul class=\"nav pull-right\">\n" +
            "    <li><a href=\"#\" id=\"buttonOpenEnterWindow\">Вход</a></li>\n" +
            "</ul>";
    }    
}
