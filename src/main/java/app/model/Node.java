package app.model;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "nodes")
@Entity
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "nodeID", nullable = false)
    private String name;

    public Node() {
    }



    public Node(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
