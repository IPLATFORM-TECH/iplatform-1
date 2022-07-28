package space.eliseev.iplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import space.eliseev.iplatform.entity.Data;

import java.util.Optional;

@Repository
public interface DataRepository extends MongoRepository<Data, String> {
    Optional<Data> findDataBySource(String source);
}