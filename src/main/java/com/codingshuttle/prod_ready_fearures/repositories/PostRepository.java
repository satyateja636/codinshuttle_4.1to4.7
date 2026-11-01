package com.codingshuttle.prod_ready_fearures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingshuttle.prod_ready_fearures.entities.PostEntity;

@Repository
public interface PostRepository extends  JpaRepository<PostEntity, Long>{

}
