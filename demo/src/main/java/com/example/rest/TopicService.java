/*package com.example.rest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.Topic;


@Service
public class TopicService {
	
	static Set<Topic> newSet;
	
	static {
		getNewSet();
		Topic topic1 = createTopic("spring", "Spring boot", "boot up description");
		Topic topic2 = createTopic("CoreJava", "Java 8", "Lambda expression");
		Topic topic3 = createTopic("DesignPattern", "Structural design pattern", "design decription");
		
		newSet.add(topic1);
		newSet.add(topic2);
		newSet.add(topic3);
		
	}
	
	public List<Topic> getTopic() {
		List<Topic> newList = new ArrayList<>();
		for(Topic topic : newSet) {
			newList.add(topic);
		}
		return newList;
	}
	
	public Topic getTopicById(String id) {
		
		Optional<Topic> optional = newSet.stream().filter(t -> t.getId().equals(id)).findFirst();
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public void addTopic(Topic newTopic) {
		newSet.add(newTopic);
	}

	private static Topic createTopic(String id, String name, String description) {
		
		Topic t1 = new Topic();
		t1.setDescription(description);
		t1.setId(id);
		t1.setName(name);
		
		return t1;
		
	}

	public static Set<Topic> getNewSet() {
		if(newSet == null) {
			newSet = new HashSet<>();
		}
		return newSet;
	}

	public static void setNewSet(Set<Topic> newSet) {
		TopicService.newSet = newSet;
	}

}
*/