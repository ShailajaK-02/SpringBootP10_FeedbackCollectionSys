package com.system.controller;

import com.system.entity.Feedback;
import com.system.service.FeedbackService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController
{
    //inject service in this controller
    @Autowired
    private FeedbackService feedbackService;

    //Add api added
    @PostMapping("/addData")
    public ResponseEntity<String> addData(@RequestBody Feedback feedback){
        feedbackService.saveFeedback(feedback);
        return new ResponseEntity<>("Feedback added", HttpStatus.CREATED);
    }

    //get all data api added
    @GetMapping("/getAllData")
    public ResponseEntity<List<Feedback>> getallData(){
        List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbackList,HttpStatus.OK);
    }

    //get data by id api added
    @GetMapping("/getDataById/{id}")
    public ResponseEntity<Feedback> getDatabyId(@PathVariable("id") int id){
        Feedback feedbackById = feedbackService.getFeedbackById(id);
        return  new ResponseEntity<>(feedbackById,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable("id") int id){
        feedbackService.deleteFeedback(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity<Feedback> updateData(@PathVariable("id") int id, @RequestBody Feedback feed){
        Feedback updatedFeedB = feedbackService.updateFeedB(id,feed);
        return new ResponseEntity<>(updatedFeedB,HttpStatus.OK);
    }
}
