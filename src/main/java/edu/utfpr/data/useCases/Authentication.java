package edu.utfpr.data.useCases;

import edu.utfpr.data.repository.UserRepository;
import edu.utfpr.domain.model.User;
import edu.utfpr.domain.useCases.IAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Authentication implements IAuthentication {
    private final UserRepository repository;

    @Override
    public User authorize(User entity) {
        User user = repository.find(entity.getCpf(), entity.getPassword());
        if (user != null) {
            return user;
        }
        throw new Error("Bad credentials");
    }
}
