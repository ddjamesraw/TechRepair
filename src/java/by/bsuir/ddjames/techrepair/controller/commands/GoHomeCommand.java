package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoHomeCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getSession().setAttribute("content", null);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            Logger.getLogger(GoHomeCommand.class.getName()).log(Level.SEVERE, null, e);
        }
    }    
}
