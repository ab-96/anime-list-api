package com.example.animeListAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin(origins  =  "http://localhost:3000")
@RestController //dictates that this class stores our endpoints
public class AnimeListController {

    @Autowired
    AnimeListRepository repository;

    @GetMapping("/all-anime")
    public List<AnimeList> getAllAnime() {
        return repository.findAll();
    }


    @GetMapping("/completed")
    public ResponseEntity getCompletedAnime() {
        List<AnimeList> completedAnime = repository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(completedAnime.stream().filter(anime ->
                anime.getCompleted()
        ).collect(Collectors.toList()));
        //transform back to list
    }

    @GetMapping("/watching")
    public ResponseEntity<List<AnimeList>> getCurrentlyWatching() {
        List<AnimeList> currentlyWatchingAnime = repository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(currentlyWatchingAnime.stream().filter(anime ->
                !anime.getCompleted()
        ).collect(Collectors.toList()));
    }
//red green blue

    @PostMapping("/add")
    public ResponseEntity addAnime(@RequestBody AnimeList animeList)  {
        repository.save(animeList);
        return ResponseEntity.status(HttpStatus.OK).body("Anime added");
    }

    @Transactional
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeAnime(@PathVariable String id) {
        repository.deleteGreetingByid(Integer.parseInt(id));
        return ResponseEntity.status(HttpStatus.OK).body("Greeting with ID " + id + " has been deleted");
    }

    @GetMapping("/all-anime/{name}")
    public ResponseEntity<String> getAnimeInfo(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body("I will display info about " + name);
    }
}
