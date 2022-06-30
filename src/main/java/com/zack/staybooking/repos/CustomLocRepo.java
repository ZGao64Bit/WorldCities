package com.zack.staybooking.repos;

import java.util.List;

public interface CustomLocRepo {
    List<Long> searchByDistance(double lat, double lon, String distance);
}
