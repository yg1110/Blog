package com.boot.Repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.dto.Member;

public interface UserRepository extends CrudRepository<Member, String>  {
}