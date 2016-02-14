package by.bsuir.ddjames.techrepair.dao.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="clients")
public class Client implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")   
    private Long id;
    
    @Column(name="login")
    private String login;
    
    @Column(name="password")
    private String password;
    
    @Column(name="fio")
    private String fio;
    
    @Column(name="passport")
    private String passport;
    
    @Column(name="address")
    private String address;
    
    @Column(name="phone")
    private String phone;
    
    @Column(name="email")
    private String email;
    
    @OneToMany(mappedBy="client")
    private Set<Order> orders;
    
    @OneToMany(mappedBy="author")
    private Set<Comment> comments;
    
    public Client() {
        this.id = null;
        this.login = null;
        this.password = null;
        this.fio = null;
        this.passport = null;
        this.address = null;
        this.phone = null;
        this.email = null;
        this.comments = null;
        this.orders = null;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFio() {
        return fio;
    }

    public String getPassport() {
        return passport;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
