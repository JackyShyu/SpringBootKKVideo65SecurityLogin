package org.shyu.springboot.repository;

import org.shyu.springboot.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {

}
