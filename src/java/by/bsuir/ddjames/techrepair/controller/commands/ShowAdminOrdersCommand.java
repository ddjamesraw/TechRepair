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

public class ShowAdminOrdersCommand implements Command {

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
        if(role != null && role.equals("administrator")) {
            ArrayList<String[]> list = new ArrayList<>();
            List<Order> data = LogicImpl.getInstance().getAllOrders();
            Collections.sort(data, comparator);
            String tmp[];
            for(Order t: data) {
                tmp = new String[17];
                tmp[0] = t.getId().toString();
                tmp[1] = t.getDescription();
                tmp[2] = t.getClient().getLogin();
                tmp[3] = t.getClient().getFio();
                tmp[4] = t.getClient().getAddress();
                tmp[5] = t.getClient().getEmail();
                tmp[6] = t.getClient().getPassport();
                tmp[7] = t.getClient().getPhone();
                tmp[8] = t.getCount().toString();
                tmp[9] = t.getDateBegin().toString().substring(0, t.getDateBegin().toString().length()-2);
                try {
                    tmp[10] = t.getDateEnd().toString().substring(0, t.getDateEnd().toString().length()-2);
                } catch (Exception e) {
                    tmp[10] = "";
                }
                tmp[11] = t.getDiscount().toString();
                try {
                    tmp[12] = t.getMaster().getFio();
                    tmp[13] = t.getMaster().getPhone();
                } catch (Exception e) {
                    tmp[12] = "";
                    tmp[13] = "";
                }
                tmp[14] = t.getStatus().getName();
                tmp[15] = t.getSumm().toString();
                tmp[16] = t.getPrice().getPrice().toString();
                list.add(tmp);
            }
            request.getSession().setAttribute("listadminorders", list);
            request.getSession().setAttribute("content", "showadminorders");
        } else {
            request.getSession().setAttribute("content", "permissiodenied");
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    } catch (ServletException | IOException ex) {
        Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, ex);
    }       
  }    
}
