package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoCommand implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("404.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(NoCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
