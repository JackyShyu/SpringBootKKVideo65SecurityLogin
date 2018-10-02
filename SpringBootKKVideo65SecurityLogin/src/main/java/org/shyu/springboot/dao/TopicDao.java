package org.shyu.springboot.dao;

import java.util.List;

import org.shyu.springboot.model.Topic;

public interface TopicDao {
	public List<Topic> getAllTopics();
}
