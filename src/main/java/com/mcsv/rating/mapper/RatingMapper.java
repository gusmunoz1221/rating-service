package com.mcsv.rating.mapper;

import com.mcsv.rating.entity.RatingEntity;
import com.mcsv.rating.response.RatingDtoRequest;
import com.mcsv.rating.response.RatingDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public RatingEntity ratingDtoToRatingEntity(RatingDtoRequest ratingDtoRequest){
        return RatingEntity.builder()
                .rating(ratingDtoRequest.getRating())
                .observations(ratingDtoRequest.getObservations())
                .userId(ratingDtoRequest.getUserId())
                .hotelId(ratingDtoRequest.getHotelId())
                .build();
    }
    public RatingDtoResponse ratingEntityToRatingDto(RatingEntity rating){
        return RatingDtoResponse.builder()
                .rating(rating.getRating())
                .observations(rating.getObservations())
                .hotelId(rating.getHotelId())
                .userId(rating.getUserId())
                .build();
    }
}
