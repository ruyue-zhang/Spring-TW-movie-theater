package com.thoughtwork.pro.Services;

import com.thoughtwork.pro.Entity.Movies;
import com.thoughtwork.pro.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<List<Movies>> getTop250() {
        List<Movies> result = new ArrayList<>();
        Iterable<Movies> all = movieRepository.findAll();
        Iterator iter = all.iterator();
        while(iter.hasNext()) {
            result.add((Movies) iter.next()) ;
        }
        return ResponseEntity.ok(result);
    }

    public Movies findById(@RequestParam(name = "id") int id) {
        return movieRepository.findById(id).orElse(null);
    }
}
