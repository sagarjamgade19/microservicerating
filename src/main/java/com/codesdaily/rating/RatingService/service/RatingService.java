package com.codesdaily.rating.RatingService.service;

import java.util.List;

import com.codesdaily.rating.RatingService.entity.Rating;
import com.codesdaily.rating.RatingService.exception.ResourceNotFound;

public interface RatingService {
public Rating getRating(String ratingId) throws ResourceNotFound;
public Rating saveRating(Rating rating);
public List<Rating>getAllRatings();
public List<Rating> getRatingsByUserId(String userId);
}
