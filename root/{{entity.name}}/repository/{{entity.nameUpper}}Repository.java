package {{path}}.{{entity.name}}.repository;

import {{path}}.{{entity.name}}.model.{{entity.nameUpper}}Doc;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface {{entity.nameUpper}}Repository extends MongoRepository<{{entity.nameUpper}}Doc, ObjectId> {
}
