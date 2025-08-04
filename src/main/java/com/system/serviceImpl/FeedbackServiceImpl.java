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

    @Override
    public String saveFeedback(Feedback feedback) {
        repository.save(feedback);
        return "Feedback saved";
    }

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
}
