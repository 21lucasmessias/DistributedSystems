package data.useCases;

import data.repository.UserRepository;
import domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Authentication {
    private final UserRepository repository;

    public User authorize(User entity) {
        User user = repository.find(entity.getCpf(), entity.getPassword());
        if (user != null) {
            return user;
        }
        throw new Error("Bad credentials");
    }
}
