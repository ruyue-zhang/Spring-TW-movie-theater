package com.thoughtwork.pro.Controllers;

import com.thoughtwork.pro.Entity.Movies;
import com.thoughtwork.pro.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v2/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("top250")
    public ResponseEntity<List<Movies>> getTop250() {
        try{
            return movieService.getTop250();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("subject")
    public Movies findById(@RequestParam(name = "id") int id) {
        try {
            return movieService.findById(id);
        } catch(RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
