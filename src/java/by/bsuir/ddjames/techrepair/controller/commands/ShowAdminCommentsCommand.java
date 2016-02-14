package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.dao.entity.Client;
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

public class ShowAdminCommentsCommand implements Command {

    static Comparator<Comment> comparator = new Comparator<Comment>() {
        @Override
        public int compare(Comment c1, Comment c2) {
            return c2.getCreatedate().compareTo(c1.getCreatedate());
        }
    };
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = null;
            try {
                role =  request.getSession().getAttribute("role").toString();
            } catch (Exception e) {
            }
            if(role != null && role.equals("administrator")) {
                ArrayList<String[]> list = new ArrayList<>();
                List<Comment> data = LogicImpl.getInstance().getAllComments();
                Collections.sort(data, comparator);
                String tmp[];
                for(Comment t: data) {
                    tmp = new String[5];
                    Client author;
                    try {
                        author = t.getAuthor();
                        tmp[0] = author.getLogin();
                    } catch (Exception e) {
                        tmp[0] = "Пользователь удален";
                    }
                    tmp[1] = t.getCreatedate().toString().substring(0, t.getCreatedate().toString().length()-2);
                    tmp[2] = t.getText();
                    tmp[3] = t.getStatus().toString();
                    tmp[4] = t.getId().toString();
                    list.add(tmp);
                }
                request.getSession().setAttribute("listcomments", list);
                request.getSession().setAttribute("content", "showadmincomments");
            } else {
                request.getSession().setAttribute("content", "permissiodenied");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(ShowCommentsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
