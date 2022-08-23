package com.infygo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infygo.entity.Passanger;

@Repository
public interface PassangerRepository extends JpaRepository<Passanger, Integer>{

}
