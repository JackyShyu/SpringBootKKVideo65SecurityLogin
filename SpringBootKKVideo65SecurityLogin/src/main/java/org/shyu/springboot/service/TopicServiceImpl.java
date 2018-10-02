package org.shyu.springboot.service;

import java.util.List;

import org.shyu.springboot.dao.TopicDaoImpl;
import org.shyu.springboot.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
	//@Autowired
	//private TopicRepository topicRepository;
	
	@Autowired
	private TopicDaoImpl topicDaoImpl;

	@Override
	public List<Topic> getAllTopics() {
		//List<Topic> topics = new ArrayList<>();
		//topicRepository.findAll().forEach(topics:: add);
		//return topics;
		
		return topicDaoImpl.getAllTopics();
	}

}
