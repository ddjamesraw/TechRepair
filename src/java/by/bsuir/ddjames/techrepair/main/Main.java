package by.bsuir.ddjames.techrepair.main;

import by.bsuir.ddjames.techrepair.dao.entity.Comment;
import by.bsuir.ddjames.techrepair.dao.impl.CommentDao;
import java.util.List;

public class Main {

    public static void main (String [] arg) {
        List<Comment> list = new CommentDao().getAll();
        for(Comment it: list) {
            System.out.println(it.getAuthor().getLogin() + " " + it.getText() + " " + it.getStatus());
        }
//        List<Client> list = new ClientDao().getAll();
//        for(Client it: list) {
//            System.out.println(it.getFio());
//        }
    }
}