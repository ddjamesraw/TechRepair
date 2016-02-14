package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.dao.entity.Order;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowOrdersCommand implements Command {

    static Comparator<Order> comparator = new Comparator<Order>() {
        @Override
        public int compare(Order c1, Order c2) {
            return c2.getDateBegin().compareTo(c1.getDateBegin());
        }
    }; 
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = null;
            try {
                role =  request.getSession().getAttribute("role").toString();
            } catch (Exception e) {
            }
            if(role != null && role.equals("client")) {
                String login = request.getSession().getAttribute("login").toString();
                ArrayList<String[]> list = new ArrayList<>();
                List<Order> data = LogicImpl.getInstance().getOrders(login);
                Collections.sort(data, comparator);
                String[] tmp;
                for(Order it: data) {
                    tmp = new String[10];
                    tmp[0] = it.getDescription();
                    tmp[1] = it.getDateBegin().toString().substring(0, it.getDateBegin().toString().length()-2);
                    try {
                        tmp[2] = it.getDateEnd().toString().substring(0, it.getDateEnd().toString().length()-2);
                    } catch (Exception e) {
                        tmp[2] = "-";
                    }
                    tmp[3] = it.getCount().toString();
                    tmp[4] = it.getDiscount().toString();
                    try {
                        tmp[5] = it.getMaster().getFio();
                        tmp[6] = it.getMaster().getPhone();
                    } catch (Exception e) {
                        tmp[5] = "-";
                        tmp[6] = "-";
                    }
                    tmp[7] = it.getSumm().toString();
                    tmp[8] = it.getStatus().getName();
                    tmp[9] = it.getPrice().getPrice().toString();
                    list.add(tmp);
                }
                request.getSession().setAttribute("listorders", list);
                request.getSession().setAttribute("content", "showorders");
            } else {
                request.getSession().setAttribute("content", "permissiodenied");
            }
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
