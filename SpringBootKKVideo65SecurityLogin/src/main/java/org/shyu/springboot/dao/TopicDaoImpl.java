package org.shyu.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.shyu.springboot.model.Topic;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class TopicDaoImpl implements TopicDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAllTopics() {
		String HQL = "from Topic as t order by t.topicId";
		return (List<Topic>) entityManager.createQuery(HQL).getResultList();
	}

}
