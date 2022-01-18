package com.example.animeListAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController //dictates that this class stores our endpoints
public class AnimeListController {

    @Autowired
    AnimeListRepository repository;

    @GetMapping("/all-anime")
    public List<AnimeList> getAllAnime() {
        return repository.findAll();
    }

    @GetMapping("/completed")
    public List getCompletedAnime() {
        List<AnimeList> completedAnime = repository.findAll();
        return completedAnime.stream().filter(anime ->
        anime.getCompleted() == true
        ).collect(Collectors.toList());
        //transform back to list
    }

    @GetMapping("/watching")
    public List getCurrentlyWatching() {
        List<AnimeList> currentlyWatchingAnime = repository.findAll();
        return currentlyWatchingAnime.stream().filter(anime ->
                anime.getCompleted() == false
        ).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public String addAnime(@RequestBody AnimeList animeList)  {
        repository.save(animeList);
        return "Anime added to list";
    }

    @Transactional
    @DeleteMapping("/remove/{id}")
    public String removeAnime(@PathVariable String id) {
        repository.deleteGreetingByid(Integer.parseInt(id));
       return "Greeting with ID " + id + "has been deleted";
    }





    @GetMapping("/all-anime/{name}")
    public String getAnimeInfo(@PathVariable String name) {
        return "I will display info about " + name;
    }


}
