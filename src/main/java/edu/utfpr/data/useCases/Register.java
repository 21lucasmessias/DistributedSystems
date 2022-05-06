package edu.utfpr.data.useCases;

import edu.utfpr.data.repository.UserRepository;
import edu.utfpr.domain.model.User;
import edu.utfpr.domain.useCases.IRegister;
import org.springframework.stereotype.Service;

@Service
public class Register implements IRegister {

    UserRepository userRepository;

    @Override
    public User perform(User entity) {
        try{
            return userRepository.insert(entity);
        } catch(Error ignored) {
            return null;
        }
    }
}
