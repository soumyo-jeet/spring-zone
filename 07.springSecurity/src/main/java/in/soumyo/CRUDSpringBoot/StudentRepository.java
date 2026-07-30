package in.soumyo.CRUDSpringBoot;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<StudentEntity, String> {
    // syntax for custom func naming -- FindBy + Fields + Condition
    Optional<StudentEntity> findByIdAndDeletedIsFalse(String id);

    Optional<List<StudentEntity>> findByDeletedIsFalseAndAgeGreaterThan(int ageIsGreaterThan);

    Optional<StudentEntity> findByName(String name);
}
