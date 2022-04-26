package data.repository;

import domain.model.User;
import domain.repository.IUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRepository {
    private final IUserRepository repository;
    private final MongoTemplate mongo;

    public User insert(User entity) throws RepositoryException {
        Query query = new Query(Criteria.where("cpf").is(entity.getCpf()));

        if (!mongo.exists(query, User.class)) {
            return repository.insert(entity);
        }

        throw new RepositoryException("CPF already exists");
    }

    public User find(String cpf, String password) {
        Query query = new Query(Criteria.where("cpf").is(cpf).and("password").is(password));
        return mongo.findOne(query, User.class);
    }
}
