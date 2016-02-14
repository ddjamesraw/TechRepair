package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(true);
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String role = LogicImpl.getInstance().getRoleByLogin(login);
            if (role != null) {
                if (LogicImpl.getInstance().login(login, password, role)) {
                    session.setAttribute("login", login);
                    session.setAttribute("role", role);
                    session.setAttribute("content", null);
                } 
            } else {
                    session.setAttribute("role", null);
                    session.setAttribute("content", "badlogin");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
