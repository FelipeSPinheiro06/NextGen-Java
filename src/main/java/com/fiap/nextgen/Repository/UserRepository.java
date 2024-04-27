package com.fiap.nextgen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.nextgen.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
