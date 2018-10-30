package app.repos;

import app.model.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NodeRepo extends CrudRepository<Node, Long> {
    List <Node> findByName(String name);
}
