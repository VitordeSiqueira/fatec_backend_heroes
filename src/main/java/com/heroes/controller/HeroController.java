package com.heroes.controller;

import java.util.List;
import java.util.Optional;

import com.heroes.entities.Hero;
import com.heroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    private HeroRepository repo;

    //EndPoint
    //Devolve todos os heroes
    @GetMapping
    public List<Hero> getHeroes() {
        List<Hero> lista = repo.findAll();
        return lista;
    }

    //ENdPoint
    //Devolve um heroi por id
    //  http://localhost:8080/heros/{id}
    @GetMapping("{id}")
    public Hero getHero(@PathVariable Long id){

        Optional<Hero> op =  repo.findById(id);
        Hero hero = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return hero;
    }

}