package com.appwithdb.ApiAppDB.service;

import com.appwithdb.ApiAppDB.DTO.Topic;
import com.appwithdb.ApiAppDB.repository.topicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class topicService {


    @Autowired
    private com.appwithdb.ApiAppDB.repository.topicRepository topicRepository;

    //defining the list of Topics to perform add, delete and update operations
    private List<Topic> topics = new ArrayList<>();

    //function to get all the topics displayed
    public List<Topic> getAllTopics()
    {
        //return topics; -> if we use list
        List<Topic> topic = new ArrayList<>();
        topicRepository.findAll() //iterating over all the topic in database
        .forEach(topic::add);
        return topic;
    }

    //function to get a single topic through id
    public com.appwithdb.ApiAppDB.DTO.Topic getTopic(String topicId)
    {
        //return topics.stream().filter(t -> t.getId().equals(topicId)).findFirst().get();
        return topicRepository.findById(topicId).get();

    }

    //function to add a topic of Course type to the list
    public void addTopic(Topic topic)
    {
        //topics.add(topic); ->when we use list
        topicRepository.save(topic);
    }

    //function to update a particular topic using id
    public void updateTopic(Topic topic, String id)
    {
//        for(int i=0;i<topics.size();i++)
//        {
//            //comparison
//            if(topics.get(i).getId().toString().equals(id) )
//            {
//                topics.set(i,topic);
//                return;
//            }
//        }

        topicRepository.save(topic);
    }

    //function to delete a particular topic using id
    public void deleteTopic(Topic topic, String id)
    {

//        topics.removeIf(t-> t.getId().equals(id));
        topicRepository.delete(topic);
    }


}
