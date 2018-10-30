package app.model;

import javax.persistence.*;

@Entity
//@Table(name ="edge",schema = "geojson", catalog = "")
public class Edge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idNode;
    private String  parentId;
    private String pathId;
//    private Node nodeByIdNode;





    public Edge() {
    }

    public Edge(String parentID, String pathID, String ID) {
        this.parentId = parentID;
        this.pathId = pathID;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }


    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }


    public int getIdNode() {
        return idNode;
    }

    public void setIdNode(int idNode) {
        this.idNode = idNode;
    }

//    @ManyToOne
//    @JoinColumn(name = "NODE_ID",referencedColumnName = "ID",nullable = false,insertable = false,updatable = false)
//    public Node getNodeByIdNode(){
//        return nodeByIdNode;
//    }
//
//    public void setNodeByIdNode(Node nodeByIdNode){
//        this.nodeByIdNode = nodeByIdNode;
//    }
}
