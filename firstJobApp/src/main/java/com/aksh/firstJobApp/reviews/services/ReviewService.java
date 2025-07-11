package com.aksh.firstJobApp.reviews.services;

import com.aksh.firstJobApp.reviews.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewService {

    List <Review> getAllReviews(Long companyId);

    void saveReviews(Long companyId, Review review);
}
