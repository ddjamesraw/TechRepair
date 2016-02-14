package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.dao.entity.Price;
import by.bsuir.ddjames.techrepair.dao.impl.PriceDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PriceListCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            List<Price> data = new PriceDao().getAll();
            String[] tmp;
            for(Price it: data) {
                tmp = new String[3];
                tmp[0] = it.getName();
                tmp[1] = it.getPrice().toString();
                tmp[2] = it.getId().toString();
                list.add(tmp);
            }
            ArrayList<String[]> list1 = new ArrayList<>();
            ArrayList<String[]> list2 = new ArrayList<>();
            ArrayList<String[]> list3 = new ArrayList<>();
            ArrayList<String[]> list4 = new ArrayList<>();
            int count = 1;
            for(String[] it: list) {
                if(count <= 10) {
                    list1.add(it);
                }
                if(count > 10 && count <= 20) {
                    list2.add(it);
                }
                if(count > 20 && count <= 30) {
                    list3.add(it);
                }
                if(count > 30) {
                    list4.add(it);
                }
                count++;
            }
            request.getSession().setAttribute("pricelist_1", list1);
            request.getSession().setAttribute("pricelist_2", list2);
            request.getSession().setAttribute("pricelist_3", list3);
            request.getSession().setAttribute("pricelist_4", list4);
            request.getSession().setAttribute("content", "pricelist");
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
