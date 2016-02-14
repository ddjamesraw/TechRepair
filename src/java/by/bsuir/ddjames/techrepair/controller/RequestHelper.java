package by.bsuir.ddjames.techrepair.controller;

import by.bsuir.ddjames.techrepair.controller.commands.AddCommentCommand;
import by.bsuir.ddjames.techrepair.controller.commands.AddOrderCommand;
import by.bsuir.ddjames.techrepair.controller.commands.AddUserPageCommand;
import by.bsuir.ddjames.techrepair.controller.commands.AddUserCommand;
import by.bsuir.ddjames.techrepair.controller.commands.CheckCommentCommand;
import by.bsuir.ddjames.techrepair.controller.commands.GoHomeCommand;
import by.bsuir.ddjames.techrepair.controller.commands.InfoUserCommand;
import by.bsuir.ddjames.techrepair.controller.commands.GetStatisticCommand;
import by.bsuir.ddjames.techrepair.controller.commands.LoginCommand;
import by.bsuir.ddjames.techrepair.controller.commands.LogoutCommand;
import by.bsuir.ddjames.techrepair.controller.commands.NoCommand;
import by.bsuir.ddjames.techrepair.controller.commands.RemoveCommentCommand;
import by.bsuir.ddjames.techrepair.controller.commands.RemoveUserCommand;
import by.bsuir.ddjames.techrepair.controller.commands.ShowAdminCommentsCommand;
import by.bsuir.ddjames.techrepair.controller.commands.ShowAdminOrdersCommand;
import by.bsuir.ddjames.techrepair.controller.commands.ShowCommentsCommand;
import by.bsuir.ddjames.techrepair.controller.commands.ShowNewsCommand;
import by.bsuir.ddjames.techrepair.controller.commands.ShowOrdersCommand;
import by.bsuir.ddjames.techrepair.controller.commands.ShowUsersCommand;
import by.bsuir.ddjames.techrepair.controller.commands.PriceListCommand;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
    
    private static RequestHelper instance = null;
    HashMap<String, Command> commands;
    
    public static RequestHelper getInstance() {
        if (instance == null) {
           instance = new RequestHelper();
        }
    return instance;
    }  
    
    RequestHelper() {
        commands = new HashMap<>();
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("showcomments", new ShowCommentsCommand());
        commands.put("checkcomment", new CheckCommentCommand());
        commands.put("removecomment", new RemoveCommentCommand());
        commands.put("shownews", new ShowNewsCommand());
        commands.put("showorders", new ShowOrdersCommand());
        commands.put("showusers", new ShowUsersCommand());
        commands.put("add_comment", new AddCommentCommand());
        commands.put("addorder", new AddOrderCommand());
        commands.put("showadmincomments", new ShowAdminCommentsCommand());
        commands.put("showadminorders", new ShowAdminOrdersCommand());
        commands.put("infouser", new InfoUserCommand());
        commands.put("gohome", new GoHomeCommand());
        commands.put("pricelist", new PriceListCommand());
        commands.put("removeuser", new RemoveUserCommand());
        commands.put("getstatistic", new GetStatisticCommand());
        commands.put("adduserpage", new AddUserPageCommand());
        commands.put("adduser", new AddUserCommand());
    }

    public Command getCommand(HttpServletRequest request) {
        Command command = commands.get(request.getParameter("action"));
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }
}
