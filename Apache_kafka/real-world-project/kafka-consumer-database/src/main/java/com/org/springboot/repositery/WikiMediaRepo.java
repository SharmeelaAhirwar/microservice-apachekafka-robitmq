package com.org.springboot.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.springboot.entity.WikimediaData;

public interface WikiMediaRepo extends JpaRepository<WikimediaData, Long> {

}
