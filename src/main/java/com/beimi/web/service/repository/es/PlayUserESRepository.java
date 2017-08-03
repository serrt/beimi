package com.beimi.web.service.repository.es;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.beimi.web.model.PlayUser;

public abstract interface PlayUserESRepository
  extends ElasticsearchCrudRepository<PlayUser, String>
{
  public abstract PlayUser findById(String paramString);
  
  public abstract PlayUser findByUsername(String username);
  
  public abstract int countByUsername(String username);
  
  public abstract PlayUser findByEmail(String email);
  
  public abstract PlayUser findByUsernameAndPassword(String username, String password);
  
  public abstract Page<PlayUser> findByDatastatus(boolean datastatus , String orgi, Pageable paramPageable);
  
  public abstract Page<PlayUser> findByDatastatusAndUsername(boolean datastatus , String orgi ,String username ,Pageable paramPageable);
}
