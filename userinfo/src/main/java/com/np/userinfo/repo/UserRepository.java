package com.np.userinfo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.np.userinfo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
