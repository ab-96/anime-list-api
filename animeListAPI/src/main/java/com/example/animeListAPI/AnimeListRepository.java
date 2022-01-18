package com.example.animeListAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeListRepository extends JpaRepository <AnimeList, String> {

    AnimeList findGreetingByCompleted(boolean completed);

    String deleteGreetingByid(int id);




}
