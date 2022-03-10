package com.qa.cat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.cat.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {

}