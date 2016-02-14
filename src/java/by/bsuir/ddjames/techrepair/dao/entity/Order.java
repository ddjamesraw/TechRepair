package by.bsuir.ddjames.techrepair.dao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")   
    private Long id;
    
    @Column(name="description")
    private String description;
    
    @Column(name="count")
    private Long count;
    
    @Column(name="discount")
    private Long discount;
    
    @Column(name="summ")
    private Long summ;
    
    @Column(name="date_begin")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateBegin;
    
    @Column(name="date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date dateEnd;
    
    @ManyToOne
    @JoinColumn(name="id_status")
    private Status status;
    
    @ManyToOne
    @JoinColumn(name="id_price")
    private Price price;
    
    @ManyToOne
    @JoinColumn(name="id_client")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name="id_master")
    private Employee master;
    
    public Order() {
        this.id = null;
        this.description = null;
        this.dateBegin = null;
        this.dateEnd = null;
        this.client = null;
        this.count = null;
        this.discount = null;
        this.master = null;
        this.price = null;
        this.status = null;
        this.summ = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getSumm() {
        return summ;
    }

    public void setSumm(Long summ) {
        this.summ = summ;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getMaster() {
        return master;
    }

    public void setMaster(Employee master) {
        this.master = master;
    }
}
