package org.shyu.springboot.repository;

import org.shyu.springboot.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
