package com.zack.staybooking.repositories;

import com.zack.staybooking.models.Location;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends ElasticsearchRepository<Location, Long>,
        CustomLocationRepository {

}
