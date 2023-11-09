package com.youcode.sunquizz.Media;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRepository extends JpaRepository<Media,Integer> {
    List<Media> findAllByType(MediaType type);
}
