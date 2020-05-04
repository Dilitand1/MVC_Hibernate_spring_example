package model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ACC")
    @NaturalId
    private String acc;

    @Column(name = "BALANCE")
    private double balance;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Person person;

    @JsonIgnore
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<Accountop> accountopList  = new ArrayList<>();

    public Account(String acc) {
        this.acc = acc;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void updateBalance() {
        this.balance = accountopList.stream().map(x->x.getOpcash()).reduce(0d,(x, y)-> x + y);
    }

    public void addAccountOp(Accountop accountop){
        accountop.setAccount(this);
        accountopList.add(accountop);
        updateBalance();
    }

    public List<Accountop> getAccountopList() {
        return accountopList;
    }

    public void setAccountopList(List<Accountop> accountopList) {
        this.accountopList = accountopList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", acc='" + acc + '\'' +
                ", person=" + person +
                '}';
    }
}
