package temp;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Iryna Tkachova on 30.03.2017.
 */
public interface SomeTableRepository extends MongoRepository<SomeTable, String> {
    List<SomeTable> findByTimestampGreaterThan(String timestamp);
}