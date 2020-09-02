package com.example.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.bo.Topic;
import com.example.demo.TopicDto;



@Service
public class TopicDaoService {
	
	private static final Logger logger = LogManager.getLogger(TopicDaoService.class);
	
	@Autowired
	TopicRepository topicRepository;

	public void addTopic(TopicDto topic) {
		
		if(topic== null) {
			throw new RuntimeException("Need a valid input");
		}
		logger.info("addTopic started");
		Topic newTopic = new Topic();
		newTopic.setId(topic.getId());
		newTopic.setName(topic.getName());
		newTopic.setDescription(topic.getDescription());
		logger.info("addTopic ended");
		topicRepository.save(newTopic);
		
	}
	
	@Cacheable(value="topic-cache")
	public Topic getTopicById(String id) {
		
		Topic topic = null;
		Optional<Topic> optionalTopic = topicRepository.findById(Integer.parseInt(id));
		if(optionalTopic.isPresent()) {
			topic = optionalTopic.get();
		}
		
		return topic;
		
	}
	
	/*@Scheduled(fixedRate=5000)
	public void addTopicToDbJob() {
		Thread.currentThread().setName("Saptarshi");
		Topic newTopic = new Topic();
		for(int i= 0; i<100; i++) {
			newTopic.setId(i);
			newTopic.setName("Job Name"+"-"+i);
			newTopic.setDescription("Job Running"+"-"+i);
		}
	
		topicRepository.save(newTopic);
	}*/
	
	public Topic getTopicByName(String topicName) {
		
		Topic topic = null;
		Optional<Topic> optionalTopic = topicRepository.findByName(topicName);
		if(optionalTopic.isPresent()) {
			topic = optionalTopic.get();
		}
		
		return topic;
		
	}

	public List<Topic> getTopic() {

		List<Topic> topicList = new ArrayList<>();
		Iterable<Topic> topicIterable = topicRepository.findAll();
		
		topicIterable.forEach(topicList::add);
		
		return topicList;

	}

}
