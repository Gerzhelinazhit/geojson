package app.model;

import javax.persistence.*;
//@Table(name ="edge",schema = "geojson", catalog = "")
@Entity
public class Edge {
    private int id;
    private int idNode;
    private String  parentId;
    private String pathId;
    private Node nodeByIdNode;





//    public EdgeEntity() {
//    }

    public Edge(String parentID, String pathID, String ID) {
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
    public Node getNodeByIdNode(){
        return nodeByIdNode;
    }

    public void setNodeByIdNode(Node nodeByIdNode){
        this.nodeByIdNode = nodeByIdNode;
    }
}
