package space.eliseev.iplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import space.eliseev.iplatform.entity.Data;

@Repository
//@Configuration
public interface DataRepository extends MongoRepository<Data, String> {
    Data findDataBySource(String name);
}
