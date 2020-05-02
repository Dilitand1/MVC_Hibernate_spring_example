package model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ACC")
    private String acc;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @JsonIgnore
    private Person person;

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

    public void addAccountOp(Accountop accountop){
        accountop.setAccount(this);
        accountopList.add(accountop);
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
