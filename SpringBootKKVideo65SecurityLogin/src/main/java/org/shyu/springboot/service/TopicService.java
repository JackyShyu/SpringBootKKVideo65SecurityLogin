package org.shyu.springboot.service;

import java.util.List;

import org.shyu.springboot.model.Topic;
import org.springframework.security.access.annotation.Secured;

public interface TopicService {
	@Secured({"ROLE_ADMIN"})
	public List<Topic> getAllTopics();
}
