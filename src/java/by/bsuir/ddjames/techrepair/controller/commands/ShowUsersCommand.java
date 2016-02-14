package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.dao.entity.Client;
import by.bsuir.ddjames.techrepair.dao.entity.Employee;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUsersCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = null;
            try {
                role =  request.getSession().getAttribute("role").toString();
            } catch (Exception e) {
            }
            if(role != null && role.equals("administrator")) {
                ArrayList<String[]> masters = new ArrayList<>();
                ArrayList<String[]> clients = new ArrayList<>();
                ArrayList<String[]> administrators = new ArrayList<>();
                ArrayList<String[]> specialists = new ArrayList<>();
                List<Client> listclients = LogicImpl.getInstance().getAllClients();
                List<Employee> listmasters = LogicImpl.getInstance().getAllMasters();
                List<Employee> listadministrators = LogicImpl.getInstance().getAllAdministrators();
                List<Employee> listspecialists = LogicImpl.getInstance().getAllSpecialists();
                String[] tmp;
                for(Client it: listclients) {
                    tmp = new String[2];
                    tmp[0] = it.getLogin();
                    tmp[1] = it.getFio();
                    clients.add(tmp);
                }
                for(Employee it: listadministrators) {
                    tmp = new String[2];
                    tmp[0] = it.getLogin();
                    tmp[1] = it.getFio();
                    administrators.add(tmp);
                }
                for(Employee it: listmasters) {
                    tmp = new String[2];
                    tmp[0] = it.getLogin();
                    tmp[1] = it.getFio();
                    masters.add(tmp);
                }
                for(Employee it: listspecialists) {
                    tmp = new String[2];
                    tmp[0] = it.getLogin();
                    tmp[1] = it.getFio();
                    specialists.add(tmp);
                }
                request.getSession().setAttribute("listclients", clients);
                request.getSession().setAttribute("listmasters", masters);
                request.getSession().setAttribute("listadministrators", administrators);
                request.getSession().setAttribute("listspecialists", specialists);
                request.getSession().setAttribute("content", "showusers");
            } else {
                request.getSession().setAttribute("content", "permissiodenied");
            }
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            request.getSession().setAttribute("content", "permissiodenied");
            Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
