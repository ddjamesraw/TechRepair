package by.bsuir.ddjames.techrepair.logic;

import by.bsuir.ddjames.techrepair.dao.entity.Client;
import by.bsuir.ddjames.techrepair.dao.entity.Comment;
import by.bsuir.ddjames.techrepair.dao.entity.Employee;
import by.bsuir.ddjames.techrepair.dao.entity.Order;
import by.bsuir.ddjames.techrepair.dao.entity.Price;
import by.bsuir.ddjames.techrepair.dao.impl.ClientDao;
import by.bsuir.ddjames.techrepair.dao.impl.CommentDao;
import by.bsuir.ddjames.techrepair.dao.impl.EmployeeDao;
import by.bsuir.ddjames.techrepair.dao.impl.OrderDao;
import by.bsuir.ddjames.techrepair.dao.impl.PriceDao;
import by.bsuir.ddjames.techrepair.dao.impl.RoleDao;
import by.bsuir.ddjames.techrepair.dao.impl.StatusDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicImpl implements Logic {

    private static LogicImpl instance = null;
        
    public static LogicImpl getInstance() {
        if (instance == null) {
           instance = new LogicImpl();
        }
    return instance;
    }  

    private LogicImpl() {}
    
    @Override
    public List<Comment> getAllComments() {    
        return new CommentDao().getAll();
    }

    @Override
    public boolean login(String login, String password, String role) {
        boolean flag = false;
        if (role.equals("client")) {
            Client client = new ClientDao().getByLogin(login);
            if(client.getPassword().equals(password)) {
                flag = true;
            }
        } else {
            Employee employee = new EmployeeDao().getByLogin(login);
            if(employee.getPassword().equals(password)) {
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean addComment(String login, String message) {
        boolean flag = false;
        try {
            Comment comment = new Comment();
            Client author = new ClientDao().getByLogin(login);
            comment.setText(message);
            comment.setAuthor(author);
            comment.setStatus(false);
            comment.setCreatedate(new java.util.Date());
            new CommentDao().create(comment);
            flag = true;
        } catch (Exception e) {}
        return flag;
    }

    @Override
    public List<Employee> getAllMasters() {
        List<Employee> list = new EmployeeDao().getAll();
        List<Employee> result = new ArrayList<>();
        for(Employee it: list) {
            if(it.getRole().getName().equals("master")) {
                result.add(it);
            }
        }
        return result;
    }

    @Override
    public List<Employee> getAllAdministrators() {
        List<Employee> list = new EmployeeDao().getAll();
        List<Employee> result = new ArrayList<>();
        for(Employee it: list) {
            if(it.getRole().getName().equals("administrator")) {
                result.add(it);
            }
        }
        return result;
    }

    @Override
    public List<Employee> getAllSpecialists() {
        List<Employee> list = new EmployeeDao().getAll();
        List<Employee> result = new ArrayList<>();
        for(Employee it: list) {
            if(it.getRole().getName().equals("specialist")) {
                result.add(it);
            }
        }
        return result;
    }

    @Override
    public List<Client> getAllClients() {
        List<Client> list = new ClientDao().getAll();
        return list;
    }

    @Override
    public String[] getInfoUser(String login, String role) {
        if(role.equals("client")) {
            Client client = new ClientDao().getByLogin(login);
            String[] t = new String[6];
            t[0] = client.getLogin();
            t[1] = client.getFio();
            t[2] = client.getPhone();
            t[3] = client.getEmail();
            t[4] = client.getAddress();
            t[5] = client.getPassport();
            return t;
        } else {
            Employee employee = new EmployeeDao().getByLogin(login);
            String[] t = new String[3];
            t[0] = employee.getLogin();
            t[1] = employee.getFio();
            t[2] = employee.getPhone();
            return t;
        }
    }

    @Override
    public String getRoleByLogin(String login) {
        Client client = new ClientDao().getByLogin(login);
        if(client != null) {
            return "client";
        }
        Employee employee = new EmployeeDao().getByLogin(login);
        if(employee != null) {
            return employee.getRole().getName();
        } else return null;
    }

    @Override
    public boolean checkComment(String id) {
        boolean flag = true;
        try {
            Long l = new Long(id);
            Comment comment = new CommentDao().getById(l);
            if(comment.getStatus()) {
                comment.setStatus(false);
            } else {
                comment.setStatus(true);
            }
            new CommentDao().update(comment);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean removeComment(String id) {
        boolean flag = true;
        try {
            Long l = new Long(id);
            Comment comment = new CommentDao().getById(l);
            new CommentDao().delete(comment);
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean removeUser(String login) {
        boolean flag = true;
        try {
            String role = LogicImpl.getInstance().getRoleByLogin(login);
            if(role.equals("client")) {
                Client client = new ClientDao().getByLogin(login);
                new ClientDao().delete(client);
            } else {
                Employee employee = new EmployeeDao().getByLogin(login);
                new EmployeeDao().delete(employee);
            }
        } catch (NumberFormatException e) {
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Order> getOrders(String login) {
        return new OrderDao().getByLogin(login);
    }

    @Override
    public String addOrder(String description, Long category, Long count,
            Long discount, String login, String password, String fio, 
            String passport, String address, String phone, String email) {
        Order order = new Order();
        order.setCount(count);
        order.setDescription(description);
        order.setDiscount(discount);
        order.setDateBegin(new Date());
        Client client = new ClientDao().getByLogin(login);
        if(client == null) {
            client = new Client();
        }
        if(client.getAddress() == null) {
            client.setAddress(address);
        }
        if(client.getFio() == null) {
            client.setFio(fio);
        }
        if(client.getPassport() == null) {
            client.setPassport(passport);
        }
        if(client.getEmail() == null) {
            client.setEmail(email);
        }
        if(client.getLogin() == null) {
            client.setLogin(login);
        }
        if(client.getPassword() == null) {
            client.setPassword(password);
        }
        Client tmp = new ClientDao().getByLogin(login);
        if (tmp == null) {
            new ClientDao().create(client);
        } else {
            new ClientDao().update(client);
        }
        order.setClient(client);
        Price price = new PriceDao().getById(category);
        order.setPrice(price);
        order.setSumm(count*(price.getPrice()*(1-discount/100)));
        order.setStatus(new StatusDao().getById(new Long(1)));
        new OrderDao().create(order);
        return "success";
    }

    @Override
    public List<Order> getAllOrders() {
        return new OrderDao().getAll();
    }

    @Override
    public int getCountOrders(String dateBegin, String dateEnd) {
        List<Order> list = getAllOrders();
        List<Order> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dBegin = sdf.parse(dateBegin.concat(" 00:00:00"));
            Date dEnd = sdf.parse(dateEnd.concat(" 23:59:59"));
            for(Order it: list) {
                if(it.getDateBegin().compareTo(dBegin) >=0 && it.getDateBegin().compareTo(dEnd) <=0) {
                    result.add(it);
                }
            }
        } catch (ParseException e) {}
        return result.size();
    }

    @Override
    public List<String[]> getCountOrdersByCategory(String dateBegin, String dateEnd) {
        List<Order> list = getAllOrders();
        List<String[]> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dBegin = sdf.parse(dateBegin.concat(" 00:00:00"));
            Date dEnd = sdf.parse(dateEnd.concat(" 23:59:59"));
            Map<String, Integer> myMap = new HashMap<>();
            String catName;
            for(Order it: list) {
                if(it.getDateBegin().compareTo(dBegin) >= 0 && it.getDateBegin().compareTo(dEnd) <= 0) {
                    catName = it.getPrice().getName();
                    if(myMap.containsKey(catName)) {
                        myMap.put(catName, myMap.get(catName) + 1);
                    } else {
                        myMap.put(catName, 1);
                    }
                }
            }
            String tmp[];
            for(Map.Entry<String, Integer> it: myMap.entrySet()) {
                tmp = new String[2];
                tmp[0] = it.getKey();
                tmp[1] = it.getValue().toString();
                result.add(tmp);
            }
        } catch (ParseException e) {}
        return result;
    }

    @Override
    public List<String[]> getCountOrdersByMaster(String dateBegin, String dateEnd) {
        List<Order> list = getAllOrders();
        List<String[]> result = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dBegin = sdf.parse(dateBegin.concat(" 00:00:00"));
            Date dEnd = sdf.parse(dateEnd.concat(" 23:59:59"));
            Map<String, Integer> myMap = new HashMap<>();
            String masterName;
            for(Order it: list) {
                if(it.getDateBegin().compareTo(dBegin) >= 0 && it.getDateBegin().compareTo(dEnd) <= 0) {
                    try {
                        masterName = it.getMaster().getFio();
                    } catch (Exception e) {
                        masterName = "empty";
                    }
                    if(myMap.containsKey(masterName)) {
                        myMap.put(masterName, myMap.get(masterName) + 1);
                    } else {
                        myMap.put(masterName, 1);
                    }
                }
            }
            String tmp[];
            for(Map.Entry<String, Integer> it: myMap.entrySet()) {
                tmp = new String[2];
                tmp[0] = it.getKey();
                tmp[1] = it.getValue().toString();
                result.add(tmp);
            }
        } catch (ParseException e) {}
        return result;
    }

    @Override
    public int getTotalSumm(String dateBegin, String dateEnd) {
        List<Order> list = getAllOrders();
        int result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dBegin = sdf.parse(dateBegin.concat(" 00:00:00"));
            Date dEnd = sdf.parse(dateEnd.concat(" 23:59:59"));
            for(Order it: list) {
                if(it.getDateBegin().compareTo(dBegin) >= 0 && it.getDateBegin().compareTo(dEnd) <= 0) {
                    try {
                        it.getMaster().getFio();
                        result += it.getSumm().intValue();
                    } catch(Exception e){}
                }
            }
        } catch (ParseException e) {}
        return result;
    }

    @Override
    public void addNewAdministrator(String newuserlogin, String newuserpassword, String newuserfio, String newuserphone) {
        Employee newAdmin = new Employee();
        newAdmin.setFio(newuserfio);
        newAdmin.setLogin(newuserlogin);
        newAdmin.setPassword(newuserpassword);
        newAdmin.setPhone(newuserphone);
        newAdmin.setRole(new RoleDao().getById(new Long(2)));
        new EmployeeDao().create(newAdmin);
    }
        
    @Override
    public void addNewMaster(String newuserlogin, String newuserpassword, String newuserfio, String newuserphone) {
        Employee newMaster = new Employee();
        newMaster.setFio(newuserfio);
        newMaster.setLogin(newuserlogin);
        newMaster.setPassword(newuserpassword);
        newMaster.setPhone(newuserphone);
        newMaster.setRole(new RoleDao().getById(new Long(1)));
        new EmployeeDao().create(newMaster);
    }

    @Override
    public void addNewSpecialist(String newuserlogin, String newuserpassword, String newuserfio, String newuserphone) {
        Employee newSpecialist = new Employee();
        newSpecialist.setFio(newuserfio);
        newSpecialist.setLogin(newuserlogin);
        newSpecialist.setPassword(newuserpassword);
        newSpecialist.setPhone(newuserphone);
        newSpecialist.setRole(new RoleDao().getById(new Long(3)));
        new EmployeeDao().create(newSpecialist);
    }

    @Override
    public void addNewClient(String newuserlogin, String newuserpassword, String newuserfio, String newuserpassport, String newuseraddress, String newuserphone, String newuseremail) {
        Client newClient = new Client();
        newClient.setFio(newuserfio);
        newClient.setLogin(newuserlogin);
        newClient.setPassword(newuserpassword);
        newClient.setPassport(newuserpassport);
        newClient.setPhone(newuserphone);
        newClient.setEmail(newuseremail);
        newClient.setAddress(newuseraddress);
        new ClientDao().create(newClient);
    }      
}

