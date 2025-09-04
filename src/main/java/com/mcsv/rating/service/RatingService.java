package com.mcsv.rating.service;

import com.mcsv.rating.response.RatingDtoRequest;
import com.mcsv.rating.response.RatingDtoResponse;
import com.mcsv.rating.response.RatingModifyRequest;

import java.util.List;

public interface RatingService {
    RatingDtoResponse saveRating(RatingDtoRequest ratingDtoRequest);
    List<RatingDtoResponse> getAllRatings();
    List<RatingDtoResponse> getUserRatings(String userId);
    List<RatingDtoResponse> getHotelRatings(String hotelId);
    RatingDtoResponse updateRating(String ratingId, RatingModifyRequest ratingModifyRequest);
    void deleteRating(String ratingId);
}
