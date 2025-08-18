package com.system.serviceImpl;

import com.system.entity.Feedback;
import com.system.repository.FeedabckRepository;
import com.system.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService
{
    //inject repository in this class
    @Autowired
    private FeedabckRepository repository;

    //save method implemented
    @Override
    public String saveFeedback(Feedback feedback) {
        repository.save(feedback);
        return "Feedback saved";
    }

    //getalldata method implemented
    @Override
    public List<Feedback> getAllFeedbacks() {
        List<Feedback> feedbackList = repository.findAll();
        return feedbackList;
    }

    @Override
    public Feedback getFeedbackById(int id) {
        Feedback feedbackById = repository.findById(id).orElseThrow(()->new NullPointerException("Data not found"+id));
        return feedbackById;
    }

    @Override
    public String deleteFeedback(int id) {
        repository.deleteById(id);
        return "Feedback deleted";
    }

    @Override
    public Feedback updateFeedB(int id, Feedback newFeedB) {
        Feedback feedback = repository.findById(id).orElseThrow(()->new NullPointerException("Data deleted"));

        feedback.setRatings(newFeedB.getRatings());

        Feedback updatedFeedback = repository.save(feedback);
        return updatedFeedback;
    }
}
