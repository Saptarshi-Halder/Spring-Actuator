package com.example.rest;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.bo.Topic;


public interface TopicRepository extends CrudRepository<Topic, Integer> {
	
	@Query("from Topic t where t.name = :topicName")
    public Optional<Topic> findByName(@Param("topicName")String topicName);

}
