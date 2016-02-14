package by.bsuir.ddjames.techrepair.dao.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="employees")
public class Employee implements Serializable {
    
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
    
    @Column(name="phone")
    private String phone;
    
    @ManyToOne
    @JoinColumn(name="id_role")
    private Role role;
    
    @OneToMany(mappedBy="master")
    private Set<Order> orders;
    
    public Employee() {
        this.id = null;
        this.login = null;
        this.password = null;
        this.fio = null;
        this.phone = null;
        this.role = null;
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
    
    public String getPhone() {
        return phone;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
