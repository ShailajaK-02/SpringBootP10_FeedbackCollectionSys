package com.system.service;

import com.system.entity.Feedback;

import java.util.List;

public interface FeedbackService
{
    //save method added
    String saveFeedback(Feedback feedback);

    //getall method added
    List<Feedback> getAllFeedbacks();

    Feedback getFeedbackById(int id);

    String deleteFeedback(int id);

    Feedback updateFeedB(int id, Feedback newFeedB);
}
