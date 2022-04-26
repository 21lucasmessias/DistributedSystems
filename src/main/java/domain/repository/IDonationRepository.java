package domain.repository;

import domain.model.Donation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDonationRepository extends MongoRepository<Donation, String> {
}
