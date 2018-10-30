package app;


import app.parser.JsonReader;
import org.springframework.boot.CommandLineRunner;

public class Main implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        main(args);
    }

    public static void main(String[] args) {
        System.out.println("----------------------------");
        JsonReader jsonReader = new JsonReader();
        jsonReader.takeInfoFromJSON();
    }

}
