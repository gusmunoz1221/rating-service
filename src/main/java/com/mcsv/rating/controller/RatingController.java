package com.mcsv.rating.controller;

import com.mcsv.rating.response.RatingDtoRequest;
import com.mcsv.rating.response.RatingDtoResponse;
import com.mcsv.rating.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<RatingDtoResponse> saveRating(@RequestBody RatingDtoRequest ratingDtoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(ratingDtoRequest));
    }

    public ResponseEntity<List<RatingDtoResponse>> getRating(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<RatingDtoResponse>> getUserRatings(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getUserRatings(userId));
    }


    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<RatingDtoResponse>> getHotelRatings(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getyHotelRatings(hotelId));
    }
}
