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
    public boolean saveReviews(Long companyId, Review review) {

        Company company = companyService.getCompanyById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
             reviewRepo.save(review);
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {

        List <Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews.stream()
                .filter(n->n.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {

        if(companyService.getCompanyById(companyId)!=null)
        {
            updatedReview.setCompany(companyService.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepo.save(updatedReview);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {

        if(companyService.getCompanyById(companyId)!=null &&
         reviewRepo.existsById(reviewId))
        {
            Review review = reviewRepo.findById(reviewId)
                    .orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            companyService.updateCompany(company, companyId);
            reviewRepo.deleteById(reviewId);
            return true;
        }
        else
        {
            return false;
        }
    }

}
