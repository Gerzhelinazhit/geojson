package app.model;

import javax.persistence.*;
@Table(name ="edges")
@Entity
public class Edge {
    private int id;
    private String sourceNodeID;
    private String  targetNodeID;
    private String edgeType;

    public Edge(String sourceNodeID, String targetNodeID, String edgeType) {
        this.sourceNodeID = sourceNodeID;
        this.targetNodeID = targetNodeID;
        this.edgeType = edgeType;
    }



    public Edge() {
    }

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sourceNodeID", nullable = false)
    public String getIdNode() {
        return sourceNodeID;
    }

    public void setIdNode(String idNode) {
        this.sourceNodeID = idNode;
    }

    @Basic
    @Column(name = "targetNodeID", nullable = false)
    public String getParentId() {
        return targetNodeID;
    }

    public void setParentId(String parentId) {
        this.targetNodeID = parentId;
    }

    @Basic
    @Column(name = "edgeType", nullable = false)
    public String getPathId() {
        return edgeType;
    }

    public void setPathId(String pathId) {
        this.edgeType = pathId;
    }

}
