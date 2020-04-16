package com.thoughtwork.pro.Repositories;

import com.thoughtwork.pro.Entity.Reviews;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ReviewRepository extends CrudRepository<Reviews, Integer> {
    @Query("SELECT id,movie_id,user_name,title,content,avatar FROM reviews where movie_id=:movie_Id")
    List<Reviews> selectReviewsById(@Param("movie_Id") int movie_Id);
}
