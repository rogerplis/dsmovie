package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.DTO.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repository.MovieRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepositorie repositorie;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){
        Page<Movie> result = repositorie.findAll(pageable);
        return result.map(MovieDTO::new);
    }
    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){
       Movie result = repositorie.findById(id).get();
       MovieDTO dto = new MovieDTO(result);
        return dto;
    }
}
