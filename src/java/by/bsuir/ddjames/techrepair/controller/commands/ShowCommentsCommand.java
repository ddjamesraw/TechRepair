package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import static by.bsuir.ddjames.techrepair.controller.commands.ShowAdminCommentsCommand.comparator;
import by.bsuir.ddjames.techrepair.dao.entity.Comment;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCommentsCommand implements Command {

    static Comparator<Comment> comparator = new Comparator<Comment>() {
        @Override
        public int compare(Comment c1, Comment c2) {
            return c2.getCreatedate().compareTo(c1.getCreatedate());
        }
    };
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            ArrayList<String[]> list = new ArrayList<>();
            List<Comment> data = LogicImpl.getInstance().getAllComments();
            Collections.sort(data, comparator);
            String[] tmp;
            for(Comment it: data) {
                if (it.getStatus()) {
                    tmp = new String[3];
                    tmp[0] = it.getAuthor().getLogin();
                    tmp[1] = it.getCreatedate().toString().substring(0, it.getCreatedate().toString().length()-2);
                    tmp[2] = it.getText();
                    list.add(tmp);
                }
            }
            request.getSession().setAttribute("listcomments", list);
            request.getSession().setAttribute("content", "showcomments");
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
