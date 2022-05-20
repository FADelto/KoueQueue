package com.example.KoueQueue.controller;

import com.example.KoueQueue.domain.Queue;
import com.example.KoueQueue.domain.User;
import com.example.KoueQueue.repos.UserRepo;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;

@Controller
public class MainController {
    public static Vector<Queue> queueList = new Vector<>();
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/enterQueue")
        public String enterQueue(@AuthenticationPrincipal User user, @RequestParam(required = false, defaultValue = "") String filter, Map<String,Object> model) throws JSONException, IOException
        {
            User userbuf = new User();
            userbuf = userRepo.findByUsername(user.getUsername());
            Queue queue = new Queue(user.getUsername(), user.getId(), userbuf.getTimePlayed());
            if (queueList.size() != 0){
                boolean alreadyInQueue = false;
                for(int i = 0; i < queueList.size(); i++) {
                    if (queueList.get(i).getId() == user.getId()) {
                        alreadyInQueue = true;
                        return "alreadyInQueue";
                    }}
                    if(!alreadyInQueue){
                        queueList.add(queue);
                    }

            }
            else{
                queueList.add(queue);
            }
            return "enterQueue";
        }

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}