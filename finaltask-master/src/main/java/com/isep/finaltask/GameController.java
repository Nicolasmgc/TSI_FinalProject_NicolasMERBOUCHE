package com.isep.finaltask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class GameController {
    //when I get the page info, the function info() is executed to return my student info
    @GetMapping(path= "/info")
    public Map<String, String> info() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Name", "Nicolas Merbouche");
        map.put("Groupe n°", "4005");
        map.put("Task variant", "5");
        map.put("Exam date", "25/04/2022");
        return map;
    }
    //to call the repository of game entity
    @Autowired
    private GameRepository gameRepository;

    //to map url to get all data from the table Game
    @GetMapping(path="/getAll")
    public List<Game> getAllBoats() {
        return gameRepository.findAll();
    }
    //to get specific game : get?id=x
    @GetMapping("/get")
    public Optional<Game> getById(
            //requestparam is to change in function of id or anything else
            @RequestParam(
                    value = "id",
                    defaultValue = "1") Integer id){
        return gameRepository.findById(Long.valueOf(id));
    }
    //function to calculate and return the sum of prices of all table Game
    @GetMapping(path="/totalprice")
    public double getTotal() {
        //map all price and addition them
        double sum = gameRepository.findAll()
                .stream()
                .mapToDouble(Game::getPrice)
                .sum();
        return sum;
    }
}