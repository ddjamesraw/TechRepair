package by.bsuir.ddjames.techrepair.controller.commands;

import by.bsuir.ddjames.techrepair.controller.Command;
import by.bsuir.ddjames.techrepair.logic.LogicImpl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUserCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String role = null;
            try {
                role =  request.getSession().getAttribute("role").toString();
            } catch (Exception e) {
            }
            if(role != null && role.equals("administrator")) {
                String newuserrole = request.getParameter("newuserrole");
                if(newuserrole.equals("administrator")) {
                    String newuserlogin = request.getParameter("newuserlogin");
                    String newuserpassword = request.getParameter("newuserpassword");
                    String newuserfio = request.getParameter("newuserfio");
                    String newuserphone = request.getParameter("newuserphone");
                    LogicImpl.getInstance().addNewAdministrator(newuserlogin, newuserpassword, newuserfio, newuserphone);
                } else {
                    if(newuserrole.equals("master")) {
                        String newuserlogin = request.getParameter("newuserlogin");
                        String newuserpassword = request.getParameter("newuserpassword");
                        String newuserfio = request.getParameter("newuserfio");
                        String newuserphone = request.getParameter("newuserphone");
                        LogicImpl.getInstance().addNewMaster(newuserlogin, newuserpassword, newuserfio, newuserphone);
                    } else {
                        if(newuserrole.equals("specialist")) {
                            String newuserlogin = request.getParameter("newuserlogin");
                            String newuserpassword = request.getParameter("newuserpassword");
                            String newuserfio = request.getParameter("newuserfio");
                            String newuserphone = request.getParameter("newuserphone");
                            LogicImpl.getInstance().addNewSpecialist(newuserlogin, newuserpassword, newuserfio, newuserphone);
                        } else {
                            if(newuserrole.equals("client")) {
                                String newuserlogin = request.getParameter("newuserlogin");
                                String newuserpassword = request.getParameter("newuserpassword");
                                String newuserfio = request.getParameter("newuserfio");
                                String newuserpassport = request.getParameter("newuserpassport");
                                String newuseraddress = request.getParameter("newuseraddress"); 
                                String newuserphone = request.getParameter("newuserphone");
                                String newuseremail = request.getParameter("newuseremail");
                                LogicImpl.getInstance().addNewClient(newuserlogin, newuserpassword, newuserfio, newuserpassport, newuseraddress, newuserphone, newuseremail);
                            }
                        }
                    }
                }
                new ShowUsersCommand().execute(request, response);
            } else {
                request.getSession().setAttribute("content", "permissiodenied");
                request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AddUserPageCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
