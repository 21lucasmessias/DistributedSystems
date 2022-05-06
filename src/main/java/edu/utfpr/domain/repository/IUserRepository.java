package edu.utfpr.domain.repository;

import edu.utfpr.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
}
