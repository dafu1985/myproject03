package com.example.myproject03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myproject03.domain.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {
	

}
