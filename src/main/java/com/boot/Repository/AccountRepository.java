package com.boot.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boot.dto.User;

@Repository
public interface AccountRepository extends CrudRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}