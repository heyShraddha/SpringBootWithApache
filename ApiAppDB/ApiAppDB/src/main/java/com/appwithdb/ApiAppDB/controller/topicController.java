package com.appwithdb.ApiAppDB.controller;

import com.appwithdb.ApiAppDB.DTO.Topic;
import com.appwithdb.ApiAppDB.service.topicService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class topicController {

    private com.appwithdb.ApiAppDB.service.topicService topicService;

    public topicController(com.appwithdb.ApiAppDB.service.topicService topicService) {
        this.topicService = topicService;
    }

    //Display all the values
    @RequestMapping("/topics")
    public List<Topic> getAllTopics()
    {
        return topicService.getAllTopics();
    }

    //Display a single entity
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id)
    {
        return topicService.getTopic(id);
    }

    //Insert Operation
    @RequestMapping(method = RequestMethod.POST,value ="/topics")
    public void addTopic(@RequestBody Topic topic)
    {
        topicService.addTopic(topic);
    }
    //update operation
    @RequestMapping(method = RequestMethod.PUT,value ="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable String id )
    {
        topicService.updateTopic(topic,id);
    }
    //delete operation
    @RequestMapping(method = RequestMethod.DELETE,value ="/topics/{id}")
    public void deleteTopic(@RequestBody Topic topic,@PathVariable String id )
    {
        topicService.deleteTopic(topic,id);
    }
}
