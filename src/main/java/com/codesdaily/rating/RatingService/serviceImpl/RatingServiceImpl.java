package com.codesdaily.rating.RatingService.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codesdaily.rating.RatingService.entity.Rating;
import com.codesdaily.rating.RatingService.exception.ResourceNotFound;
import com.codesdaily.rating.RatingService.repo.RatingRepo;
import com.codesdaily.rating.RatingService.service.RatingService;
@Service
public class RatingServiceImpl implements RatingService{
@Autowired
private RatingRepo ratingRepo;

//Add Rating 
public Rating saveRating(Rating rating) {
 String ratingId=UUID.randomUUID().toString();
 rating.setRatingId(ratingId);
	return this.ratingRepo.save(rating);
}

public Rating getRating(String ratingId) throws ResourceNotFound {
	return ratingRepo.findById(ratingId).orElseThrow(()->new ResourceNotFound("Resource Not Found with Id "+ratingId));
}

@Override
public List<Rating> getAllRatings() {
	// TODO Auto-generated method stub
	return ratingRepo.findAll();
}

@Override
public List<Rating> getRatingsByUserId(String userId) {
	// TODO Auto-generated method stub
	return ratingRepo.findRatingByUserId(userId);
}
}
