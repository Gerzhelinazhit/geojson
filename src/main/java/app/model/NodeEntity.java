package app.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "node", schema ="geojson", catalog = "")
public class NodeEntity {

    private int id;
    private String name;
    private Collection<EdgeEntity> edgesById;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 55)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "nameById")
    public Collection<EdgeEntity> getEdgesById(){
        return edgesById;
    }

    public void setEdgesById(Collection<EdgeEntity> edgesById){
        this.edgesById = edgesById;
    }
}
