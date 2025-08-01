package com.aksh.firstJobApp.reviews.services;

import com.aksh.firstJobApp.reviews.entities.Review;

import java.util.List;

public interface ReviewService {

    List <Review> getAllReviews(Long companyId);

    boolean saveReviews(Long companyId, Review review);

    Review getReview(Long companyId, Long reviewId);

    boolean updateReview(Long companyId, Long reviewId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
