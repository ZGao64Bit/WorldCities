package com.zack.staybooking.repos;

import com.zack.staybooking.models.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocRepo extends ElasticsearchRepository<Location, Long>, CustomLocRepo {

}
