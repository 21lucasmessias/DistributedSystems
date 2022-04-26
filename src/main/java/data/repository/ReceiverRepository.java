package data.repository;

import domain.model.Donation;
import domain.model.Receive;

import domain.repository.IReceiverRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReceiverRepository {

    private final IReceiverRepository repository;
    private final MongoTemplate mongo;

    public Receive insert(Receive entity) throws RepositoryException {
        Query query = new Query(Criteria.where("idDonation").is(entity.getIdDonation()));
        if (!mongo.exists(query, Donation.class)) {
            return repository.insert(entity);
        }
        throw new RepositoryException("External code already exists");
    }
}
