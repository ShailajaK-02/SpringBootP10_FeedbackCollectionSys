package com.system.service;

import com.system.entity.Feedback;

import java.util.List;

public interface FeedbackService
{
    String saveFeedback(Feedback feedback);

    List<Feedback> getAllFeedbacks();

    Feedback getFeedbackById(int id);

    String deleteFeedback(int id);

    Feedback updateFeedB(int id, Feedback newFeedB);
}
