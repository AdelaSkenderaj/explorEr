package com.explorer.controller;

import com.explorer.entity.ReviewEntity;
import com.explorer.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/university/reviews")
    public ResponseEntity<ReviewEntity> postReview(ReviewEntity review) {
        return ok(reviewService.createReview(review));
    }

    @GetMapping("/university/{universityId}/reviews")
    public ResponseEntity<List<ReviewEntity>> getReviewsByUniversityId(@PathVariable Long universityId){
        return ok(reviewService.getReviewsByUniversityId(universityId));
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ok().build();
    }
}
