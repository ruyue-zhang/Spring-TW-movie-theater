package com.thoughtwork.pro.Repositories;

import com.thoughtwork.pro.Entity.Movies;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movies,Integer> {
}
