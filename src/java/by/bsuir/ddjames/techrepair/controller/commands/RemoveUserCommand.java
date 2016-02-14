package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveUserCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = null;
            try {
                role =  request.getSession().getAttribute("role").toString();
            } catch (Exception e) {
            }
            if(role != null && role.equals("administrator")) {
                String login = request.getParameter("userlogin");
                LogicImpl.getInstance().removeUser(login);
                new ShowUsersCommand().execute(request, response);
            } else {
                request.getSession().setAttribute("content", "permissiodenied");
                request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
