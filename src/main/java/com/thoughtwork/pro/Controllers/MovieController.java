package com.thoughtwork.pro.Controllers;

import com.thoughtwork.pro.Entity.Movies;
import com.thoughtwork.pro.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("v2/movie")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("top250")
    public ResponseEntity<List<Movies>> getTop250() {
        List<Movies> result = new ArrayList<>();
        Iterable<Movies> all = movieRepository.findAll();
        Iterator iter = all.iterator();
        while(iter.hasNext()) {
           result.add((Movies) iter.next()) ;
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("subject")
    public Movies findById(@RequestParam(name = "id") int id) {
        return movieRepository.findById(id).orElse(null);
    }
}
