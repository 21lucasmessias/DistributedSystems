package edu.utfpr.domain.useCases;

import edu.utfpr.domain.model.User;

public interface IAuthentication {
    public User authorize(User entity);
}
