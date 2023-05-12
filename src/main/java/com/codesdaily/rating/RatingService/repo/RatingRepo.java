package com.codesdaily.rating.RatingService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codesdaily.rating.RatingService.RatingServiceApplication;
import com.codesdaily.rating.RatingService.entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, String>{

	public List<Rating>findRatingByUserId(String userId);
	
}
