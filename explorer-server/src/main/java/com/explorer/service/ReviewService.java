package com.explorer.service;

import com.explorer.entity.ReviewEntity;
import com.explorer.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewEntity createReview(ReviewEntity review) {
        return reviewRepository.save(review);
    }

    public List<ReviewEntity> getReviewsByUniversityId(Long universityId) {
        return reviewRepository.getReviewsByUniversityId(universityId);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
