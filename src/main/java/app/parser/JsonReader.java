package app.parser;

import app.repos.EdgeRepo;
import app.repos.NodeRepo;
import com.google.gson.Gson;
import app.model.Edge;
import app.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class JsonReader {

    Gson gson = new Gson();
    private ArrayList<Edge> edges = new ArrayList<Edge>();
    private ArrayList<Node> nodes = new ArrayList<Node>();

    public void takeInfoFromJSON() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Hurski_R\\IdeaProjects\\geojson\\src\\main\\resources\\geojson.json"));
            JsonModel.GeoJson result = gson.fromJson(bufferedReader, JsonModel.GeoJson.class);

            if (result != null) {
                for (JsonModel.Features t : result.getFeatures()) {
                    //System.out.println(t.properties.id);
                    System.out.println(t.properties.parentId + "    " + t.properties.pathId);
                    nodes.add(new Node((t.properties.id)));
                    String pathId = t.properties.pathId;
                    if (!pathId.equals("")) {
                        if (pathId.contains(",")) {
                            String[] pathIds = pathId.split(", ");
                            for (String str : pathIds) {
                                edges.add(new Edge(t.properties.id, str, "path"));
                            }
                        } else {
                            edges.add(new Edge(t.properties.id, t.properties.pathId, "path"));
                        }
                        if(!t.properties.parentId.equals("")){
                            edges.add(new Edge(t.properties.id, t.properties.parentId, "child-to-parent"));
                            edges.add(new Edge( t.properties.parentId, t.properties.id, "parent-to-child"));
                        }
                    } else {
                        edges.add(new Edge(t.properties.id, t.properties.parentId, "child-to-parent"));
                        edges.add(new Edge( t.properties.parentId, t.properties.id, "parent-to-child"));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        System.out.println("--------------------------------------");
        /*for (Edge edge : edges) {
            System.out.println(edge.getParentId() + "   " + edge.getPathId() + "   " + edge.getNodeByIdNode());
        }*/



    }



    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}

