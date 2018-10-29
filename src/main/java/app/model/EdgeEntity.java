package app.model;

import javax.persistence.*;

@Entity
@Table(name ="edge",schema = "parser", catalog = "")
public class EdgeEntity {
    private int id;
    private int idNode;
    private String  parentId;
    private String pathId;
    private NodeEntity nodeByIdNode;





//    public EdgeEntity() {
//    }

    public EdgeEntity(String parentID, String pathID, String ID) {
        this.parentId = parentID;
        this.pathId = pathID;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PARENT", length = 55)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "PATH", length = 55)
    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    @Basic
    @Column(name = "NODE_ID", nullable = false)
    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

    @ManyToOne
    @JoinColumn(name = "NODE_ID",referencedColumnName = "ID",nullable = false,insertable = false,updatable = false)
    public NodeEntity getNodeByIdNode(){
        return nodeByIdNode;
    }

    public void setNodeByIdNode(NodeEntity nodeByIdNode){
        this.nodeByIdNode = nodeByIdNode;
    }
}
