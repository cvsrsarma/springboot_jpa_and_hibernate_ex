package com.sb.orm.ex.step4.relationships;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long>{

}
