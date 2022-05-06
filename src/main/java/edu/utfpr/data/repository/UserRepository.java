package edu.utfpr.data.repository;

import edu.utfpr.data.validators.UserValidator;
import edu.utfpr.domain.model.User;
import edu.utfpr.domain.repository.IUserRepository;
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

    private final UserValidator userValidator;

    public User insert(User entity) throws RepositoryException, Error {
        userValidator.validate(entity);

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
