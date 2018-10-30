package app.repos;

import app.model.Edge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdgeRepo extends CrudRepository<Edge, Long> {
}
