package com.codesdaily.rating.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codesdaily.rating.RatingService.entity.Rating;
import com.codesdaily.rating.RatingService.exception.ResourceNotFound;
import com.codesdaily.rating.RatingService.service.RatingService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
private RatingService ratingService;
@PostMapping("/addRating")
public ResponseEntity<Rating> addRating(@RequestBody Rating rating) {
	return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.saveRating(rating));
	
}

@GetMapping("/{ratingId}")
public ResponseEntity<Rating> getRating(@PathVariable String ratingId) throws ResourceNotFound {
	return ResponseEntity.ok(ratingService.getRating(ratingId));
}

@GetMapping("/allRatings")
public ResponseEntity<List<Rating>>geAllRatings(){
	return ResponseEntity.ok(ratingService.getAllRatings());
}
@GetMapping("/user/{userId}")
public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
 return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
}


}