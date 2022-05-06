package edu.utfpr.domain.repository;

import edu.utfpr.domain.model.Receive;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface IReceiverRepository extends MongoRepository<Receive, String> {
}
