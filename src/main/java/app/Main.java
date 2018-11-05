package app;



import app.model.Edge;
import app.model.Node;
import app.parser.JsonReader;
import app.repos.EdgeRepo;
import app.repos.NodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;


@Component
public class Main implements CommandLineRunner {

    @Autowired
    private NodeRepo nodeRepo;

    @Autowired
    private EdgeRepo edgeRepo;

    public Main() {
    }

    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    public void main(String[] args) {
        System.out.println("----------------------------");
        JsonReader jsonReader = new JsonReader();
        jsonReader.takeInfoFromJSON();
        /*for (Node t:jsonReader.getNodes()) {
            nodeRepo.save(t);
        }*/
        for (Edge t:jsonReader.getEdges()) {
            edgeRepo.save(t);
        }


    }

}
