package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        try {
            session.setAttribute("login", null);
            session.setAttribute("role", null);
            session.setAttribute("content", null);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LogoutCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
