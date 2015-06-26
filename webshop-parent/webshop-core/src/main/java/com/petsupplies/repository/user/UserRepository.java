package com.petsupplies.repository.user;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.petsupplies.model.user.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>
{

   User findByUsername(String username);

}
