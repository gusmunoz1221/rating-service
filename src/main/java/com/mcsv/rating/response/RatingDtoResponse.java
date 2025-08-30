package com.mcsv.rating.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDtoResponse {
    private String rating;
    private String observations;
    private String userId;
    private String hotelId;

}
