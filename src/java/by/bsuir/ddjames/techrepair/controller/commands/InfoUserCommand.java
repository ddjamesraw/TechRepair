package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoUserCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String login = request.getParameter("userlogin");
            String role = LogicImpl.getInstance().getRoleByLogin(login);
            String[] t = LogicImpl.getInstance().getInfoUser(login, role);
            request.getSession().setAttribute("content", "infouser");
            request.getSession().setAttribute("userdata", t);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(InfoUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
