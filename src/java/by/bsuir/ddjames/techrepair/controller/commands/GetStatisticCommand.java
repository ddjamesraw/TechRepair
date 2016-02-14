package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStatisticCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       try {
            String role = null;
            try {
                role =  request.getSession().getAttribute("role").toString();
            } catch (Exception e) {
            }
            if(role != null && role.equals("specialist")) {
                String countOrders = null;
                String countOrdersByCategory = null;
                String countOrdersbyMaster = null;
                String totalSumm = null;
                String dateBegin = null;
                String dateEnd = null;
                try {
                    countOrders = request.getParameter("count_orders");
                } catch (Exception e) {}
                try {
                    countOrdersByCategory = request.getParameter("count_orders_by_category");
                } catch (Exception e) {}
                try {
                    countOrdersbyMaster = request.getParameter("count_orders_by_master");
                } catch (Exception e) {}
                try {
                    totalSumm = request.getParameter("total_summ");
                } catch (Exception e) {}
                try {
                    dateBegin = request.getParameter("datebegin");
                } catch (Exception e) {}
                try {
                    dateEnd = request.getParameter("dateend");
                } catch (Exception e) {}
                
                if(countOrders != null) {
                    request.getSession().setAttribute("stat_count_orders", LogicImpl.getInstance().getCountOrders(dateBegin, dateEnd));                
                } else {
                    request.getSession().setAttribute("stat_count_orders", null);                
                }
                if(countOrdersByCategory != null) {
                    request.getSession().setAttribute("stat_count_orders_by_category", LogicImpl.getInstance().getCountOrdersByCategory(dateBegin, dateEnd));                
                } else {
                    request.getSession().setAttribute("stat_count_orders_by_category", null);                
                }
                if(countOrdersbyMaster != null) {
                    request.getSession().setAttribute("stat_count_orders_by_master", LogicImpl.getInstance().getCountOrdersByMaster(dateBegin, dateEnd));                
                } else {
                    request.getSession().setAttribute("stat_count_orders_by_master", null);                
                }
                if(totalSumm != null) {
                    request.getSession().setAttribute("stat_total_summ", LogicImpl.getInstance().getTotalSumm(dateBegin, dateEnd));                
                } else {
                    request.getSession().setAttribute("stat_total_summ", null);                
                }               
                request.getSession().setAttribute("stat_date_begin", dateBegin);
                request.getSession().setAttribute("stat_date_end", dateEnd);
                request.getSession().setAttribute("content", "getstatistic");
            } else {
                request.getSession().setAttribute("content", "permissiodenied");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
       } catch (ServletException | IOException ex) {
            Logger.getLogger(GetStatisticCommand.class.getName()).log(Level.SEVERE, null, ex);       
       }
    }    
}
