package app.parser;

import app.model.Edge;
import app.repos.NodeRepo;
import com.google.gson.Gson;
import app.model.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@Component
public class JsonReader {
    @Autowired
    Gson gson;
    @Autowired
    NodeRepo nodeRepo;


    public void takeInfoFromJSON() {
        BufferedReader bufferedReader = null;
        ArrayList<Edge> edges = new ArrayList<Edge>();
        ArrayList<Node> nodes = new ArrayList<Node>();
        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Zayats_A\\IdeaProjects\\parser\\src\\main\\resources\\geojson_m_prop.json"));
            JsonModel.GeoJson result = gson.fromJson(bufferedReader, JsonModel.GeoJson.class);

            if (result != null) {
                for (JsonModel.Features t : result.getFeatures()) {
                    //System.out.println(t.properties.id);
                    System.out.println(t.properties.parentId + "    " + t.properties.pathId);
                    nodes.add(new Node((t.properties.id)));
                    String pathId = t.properties.pathId;
                    if (pathId != null) {
                        if (pathId.contains(",")) {
                            String[] pathIds = pathId.split(", ");
                            for (String str : pathIds) {
                                edges.add(new Edge(t.properties.parentId, str, t.properties.id));
                            }
                        } else {
                            edges.add(new Edge(t.properties.parentId, t.properties.pathId, t.properties.id));
                        }
                    } else {
                        edges.add(new Edge(t.properties.parentId, t.properties.pathId, t.properties.id));
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
        for (Edge edge : edges) {
//            System.out.println(edge.getParentId() + "   " + edge.getPathId() + "   " + edge.getNodeByIdNode());
        }
        nodeRepo.save(nodes.get(0));
    }
}

