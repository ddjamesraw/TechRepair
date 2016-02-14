package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddCommentCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        String login = session.getAttribute("login").toString();
        String message = request.getParameter("message");
        LogicImpl.getInstance().addComment(login, message);
        new ShowCommentsCommand().execute(request, response);
    }
}
