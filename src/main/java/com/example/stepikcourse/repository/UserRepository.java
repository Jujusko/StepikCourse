package com.example.stepikcourse.repository;

import com.example.stepikcourse.model.Task;
import com.example.stepikcourse.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends PagingAndSortingRepository<Task, Long>, Authentication,CrudRepository<Task, Long>
{
    @Modifying

    Optional<User> findByLogin(String login);

}
