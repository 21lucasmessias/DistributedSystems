package edu.utfpr.domain.repository;

import edu.utfpr.domain.model.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDonationRepository extends MongoRepository<Donation, String> {
}
