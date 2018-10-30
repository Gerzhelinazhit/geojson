package app.model;

import javax.persistence.*;
import java.util.Collection;

//@Table(name = "node", schema ="geojson", catalog = "")
@Entity
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
//    private Collection<Edge> edgesById;

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

//    @OneToMany(mappedBy = "nodeByIdNode")
//    public Collection<Edge> getEdgesById(){
//        return edgesById;
//    }
//
//    public void setEdgesById(Collection<Edge> edgesById){
//        this.edgesById = edgesById;
//    }
}
