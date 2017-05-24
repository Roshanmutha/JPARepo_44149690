package com.rcmutha.usl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rcmutha.usl.controller.UserDetailModel;

@Repository
public interface UserRepository extends CrudRepository<UserDetailModel, Long> {
}
