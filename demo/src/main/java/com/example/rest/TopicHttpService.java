package com.example.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bo.Topic;
import com.example.demo.TopicDto;


@RestController
public class TopicHttpService {
	
	@Autowired
	TopicDaoService topicService;
	
	@RequestMapping(value = "/topic", produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public @ResponseBody List<TopicDto> getTopics() {
		List<TopicDto> topiclist = new ArrayList<>();
		List<Topic> listOfTopics = topicService.getTopic();
		
		for(Topic topic : listOfTopics) {
			TopicDto dto = new TopicDto();
			dto.setName(topic.getName());
			dto.setDescription(topic.getDescription());
			dto.setId(topic.getId());
			
			topiclist.add(dto);
		}
		
		return topiclist;
	}
	
	@RequestMapping(value = "/sessionInfo",method=RequestMethod.PUT)
	public void updateSession(HttpSession session) {
		session.setAttribute("user", "Saptarshi");
		
	}
	
	@RequestMapping(value = "/topic/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public @ResponseBody TopicDto getTopicById(@PathVariable String id) {
		Topic topic = topicService.getTopicById(id);
		TopicDto dto = new TopicDto();
		dto.setName(topic.getName());
		dto.setDescription(topic.getDescription());
		dto.setId(topic.getId());
		
		return dto;
	}
	
	@RequestMapping(value = "/topic/name/{topicName}", produces = MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public @ResponseBody TopicDto getTopicByName(@PathVariable String topicName) {
		Topic topic = topicService.getTopicByName(topicName);
		TopicDto dto = new TopicDto();
		dto.setName(topic.getName());
		dto.setDescription(topic.getDescription());
		dto.setId(topic.getId());
		
		return dto;
	}
	
	
	@RequestMapping(value = "/add", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addTopic(@RequestBody TopicDto topic) {
		topicService.addTopic(topic);
		return "DONE";
	}

}
