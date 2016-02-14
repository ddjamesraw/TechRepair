package by.bsuir.ddjames.techrepair.logic;

import by.bsuir.ddjames.techrepair.dao.entity.Client;
import by.bsuir.ddjames.techrepair.dao.entity.Comment;
import by.bsuir.ddjames.techrepair.dao.entity.Employee;
import by.bsuir.ddjames.techrepair.dao.entity.Order;
import java.util.List;

public interface Logic {
    
    public List<Comment> getAllComments();
    public List<Employee> getAllMasters();
    public List<Order> getAllOrders();
    public List<Client> getAllClients();
    public List<Employee> getAllAdministrators();
    public List<Employee> getAllSpecialists();
    public boolean login(String login, String password, String role);
    public boolean addComment(String login, String message);
    public String[] getInfoUser(String login, String role);
    public String getRoleByLogin(String login);
    public boolean checkComment(String id);
    public boolean removeComment(String id);
    public boolean removeUser(String id);
    public List<Order> getOrders(String login);
    public String addOrder(String description, Long category, Long count, Long discount, String login, String password, String fio, String passport, String address, String phone, String email);
    public int getCountOrders(String dateBegin, String dateEnd);
    public List<String[]> getCountOrdersByCategory(String dateBegin, String dateEnd);
    public List<String[]> getCountOrdersByMaster(String dateBegin, String dateEnd);
    public int getTotalSumm(String dateBegin, String dateEnd);
    public void addNewAdministrator(String newuserlogin, String newuserpassword, String newuserfio, String newuserphone);
    public void addNewSpecialist(String newuserlogin, String newuserpassword, String newuserfio, String newuserphone);
    public void addNewMaster(String newuserlogin, String newuserpassword, String newuserfio, String newuserphone);
    public void addNewClient(String newuserlogin, String newuserpassword, String newuserfio, String newuserpassport, String newuseraddress, String newuserphone, String newuseremail);
}
