package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddOrderCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = null;
            try {
                role =  request.getSession().getAttribute("role").toString();
            } catch (Exception e) {
            }
            if(role != null && role.equals("specialist")) {
                String description = null;
                Long count = null;
                Long discount = null;
                String login = null;
                String password = null;
                String fio = null;
                String passport = null;
                String address = null;
                String phone = null;
                String email = null;
                Long category = null;
                description = request.getParameter("description");
                category = new Long(request.getParameter("category"));
                count = new Long(request.getParameter("count"));
                discount = new Long(request.getParameter("discount"));
                login = request.getParameter("newlogin");
                password = request.getParameter("newpassword");
                fio = request.getParameter("fio");
                passport = request.getParameter("passport");
                try {
                    address = request.getParameter("address");
                } catch (Exception e) {}
                try {
                    phone = request.getParameter("phone");
                } catch (Exception e) {}
                try {
                    email = request.getParameter("email");
                } catch (Exception e) {}
                String result = LogicImpl.getInstance().addOrder(description, category, count, discount, login, password, fio, passport, address, phone, email);
                request.getSession().setAttribute("addorderresult", result);
                request.getSession().setAttribute("content", "showaddorderresult");
            } else {
                request.getSession().setAttribute("content", "permissiodenied");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (NumberFormatException | ServletException | IOException e) {
            Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}    

