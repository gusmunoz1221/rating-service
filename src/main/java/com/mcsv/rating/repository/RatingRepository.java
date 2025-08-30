package com.mcsv.rating.repository;

import com.mcsv.rating.entity.RatingEntity;
import com.mcsv.rating.response.RatingDtoResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<RatingEntity,String> {
    List<RatingDtoResponse> findByUserId(String userId);
    List<RatingDtoResponse> findByHotelId(String hotelId);
}
