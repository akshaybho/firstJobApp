package com.aksh.firstJobApp.reviews.controllers;

import com.aksh.firstJobApp.reviews.entities.Review;
import com.aksh.firstJobApp.reviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),
                HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review)
    {
        reviewService.saveReviews(companyId, review);
        return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
    }

}
