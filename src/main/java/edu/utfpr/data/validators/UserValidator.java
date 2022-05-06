package edu.utfpr.data.validators;

import edu.utfpr.domain.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserValidator {
    public void validate(User user) throws Error {
        if(!Validators.validateCPF(user.getCpf())) {
            throw new Error("CPF must be not null");
        }

        if(!Validators.validateString(user.getName())) {
            throw new Error("Name must be not null");
        }

        if(!Validators.validateString(user.getPassword())) {
            throw new Error("Password must be not null");
        }

        if(!Validators.validateString(user.getPhone())) {
            throw new Error("Phone must be not null");
        }
    }
}
