package com.mcsv.rating.service.impl;

import com.mcsv.rating.entity.RatingEntity;
import com.mcsv.rating.exceltions.ResourceNotFoundException;
import com.mcsv.rating.mapper.RatingMapper;
import com.mcsv.rating.repository.RatingRepository;
import com.mcsv.rating.response.RatingDtoRequest;
import com.mcsv.rating.response.RatingDtoResponse;
import com.mcsv.rating.response.RatingModifyRequest;
import com.mcsv.rating.service.RatingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<RatingDtoResponse> getHotelRatings(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    @Transactional
    public RatingDtoResponse updateRating(String ratingId, RatingModifyRequest ratingModifyRequest) {
        RatingEntity rating = ratingRepository.findById(ratingId)
                .orElseThrow(()-> new ResourceNotFoundException("la calificacion no se encontro"));

        ratingMapper.ratingModifyToEntity(ratingModifyRequest,rating);
        ratingRepository.save(rating);

        return ratingMapper.ratingEntityToRatingDto(rating);
    }

    @Override
    public void deleteRating(String ratingId) {
        RatingEntity rating = ratingRepository.findById(ratingId)
                .orElseThrow(()-> new ResourceNotFoundException("la calificacion que desea eliminar no existe"));
        ratingRepository.delete(rating);
    }
}
