package edu.utfpr.data.repository;

import edu.utfpr.domain.model.Donation;
import edu.utfpr.domain.model.Receive;

import edu.utfpr.domain.repository.IReceiverRepository;
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
