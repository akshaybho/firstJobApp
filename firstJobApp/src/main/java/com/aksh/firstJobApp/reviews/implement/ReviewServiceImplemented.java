package com.aksh.firstJobApp.reviews.implement;

import com.aksh.firstJobApp.company.entities.Company;
import com.aksh.firstJobApp.company.services.CompanyService;
import com.aksh.firstJobApp.reviews.entities.Review;
import com.aksh.firstJobApp.reviews.repositories.ReviewRepository;
import com.aksh.firstJobApp.reviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImplemented implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Long companyId) {

        List <Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void saveReviews(Long companyId, Review review) {

        Company company = companyService.getCompanyById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
             reviewRepo.save(review);
        }
    }

}
