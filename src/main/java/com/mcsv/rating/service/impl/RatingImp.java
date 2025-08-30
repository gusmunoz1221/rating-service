package com.mcsv.rating.service.impl;

import com.mcsv.rating.entity.RatingEntity;
import com.mcsv.rating.mapper.RatingMapper;
import com.mcsv.rating.repository.RatingRepository;
import com.mcsv.rating.response.RatingDtoRequest;
import com.mcsv.rating.response.RatingDtoResponse;
import com.mcsv.rating.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingImp implements RatingService {
    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    public RatingImp(RatingRepository ratingRepository, RatingMapper ratingMapper) {
        this.ratingMapper = ratingMapper;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public RatingDtoResponse saveRating(RatingDtoRequest ratingDtoRequest) {
        RatingEntity rating = ratingMapper.ratingDtoToRatingEntity(ratingDtoRequest);
        ratingRepository.save(rating);

        return ratingMapper.ratingEntityToRatingDto(rating);
    }

    @Override
    public List<RatingDtoResponse> getAllRatings() {
        return ratingRepository.findAll()
                .stream()
                .map(ratingMapper::ratingEntityToRatingDto)
                .toList();
    }

    @Override
    public List<RatingDtoResponse> getUserRatings(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<RatingDtoResponse> getyHotelRatings(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
