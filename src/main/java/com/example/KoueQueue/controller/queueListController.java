package com.example.KoueQueue.controller;

import com.example.KoueQueue.domain.ListOfGames;
import com.example.KoueQueue.domain.User;
import com.example.KoueQueue.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import static com.example.KoueQueue.controller.MainController.*;

@Controller
@RequestMapping("/queueList")
@PreAuthorize("hasAuthority('ADMIN')")
public class queueListController {
    Vector<ListOfGames> activeGameList = new Vector<>();
    @Autowired
    private UserRepo userRepo;
    @GetMapping
    public String queueList(Map<String,Object> model) {
        model.put("queueList", queueList);
        model.put("activeGameList", activeGameList);
        String pastTime = "null";
        model.put("pastTime", pastTime);
        return "queueList";
    }
    @GetMapping("{user}")
    public String queueListAdd(@PathVariable User user){
        for(int i = 0; i < queueList.size(); i++){
            if(queueList.get(i).getId() == user.getId()){
                queueList.remove(i);
            }
        }
        user.setTimePlayed(user.getTimePlayed() + 1);
        userRepo.save(user);
        SimpleDateFormat formater = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        if(activeGameList.size() == 0){
            ListOfGames activeGame = new ListOfGames(user.getUsername(), "null", "null", "null", formater.format((date)));
            activeGameList.add(activeGame);}
        else{
            for(int i = 0; i < activeGameList.size(); i++){
                if(activeGameList.get(i).getFirstPlayer().equals("null")){
                    activeGameList.get(i).setFirstPlayer(user.getUsername());
                }else{
                    if(activeGameList.get(i).getSecondPlayer().equals("null")){
                        activeGameList.get(i).setSecondPlayer(user.getUsername());
                    }
                    else{ if(activeGameList.get(i).getThirdPlayer().equals("null")){
                        activeGameList.get(i).setThirdPlayer(user.getUsername());
                    }else{
                        if(activeGameList.get(i).getFourthPlayer().equals("null")){
                            activeGameList.get(i).setFourthPlayer(user.getUsername());
                        }
                        else{
                            boolean allFourthPlayerExist = true;
                            for (ListOfGames listOfGames : activeGameList) {
                                if (listOfGames.getFourthPlayer().equals("null")) {
                                    allFourthPlayerExist = false;
                                }
                            }
                            if(allFourthPlayerExist){
                                ListOfGames activeGame = new ListOfGames("null", "null", "null", "null", formater.format((date)));
                                activeGameList.add(activeGame);
                            }
                        }
                    }

                    }
                }
            }
        }
        return "redirect:/queueList";
    }
    @GetMapping("/reset")
    public String enterQueue()
    {
        //@Query(value="SELECT time_played FROM usr",nativeQuery=true)
        List<User> userList = new Vector<>();
        userList = userRepo.findAll();
        for(User user : userList){
            user.setTimePlayed(0);
            userRepo.save(user);
        }
        queueList.removeAllElements();
        activeGameList.removeAllElements();
        return "redirect:/queueList";
    }
}
