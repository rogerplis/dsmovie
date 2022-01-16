package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.DTO.MovieDTO;
import com.devsuperior.dsmovie.DTO.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repository.MovieRepositorie;
import com.devsuperior.dsmovie.repository.ScoreRepository;
import com.devsuperior.dsmovie.repository.UserRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    @Autowired
    private MovieRepositorie movieRepositorie;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private UserRepositorie userRepositorie;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {

        User user = userRepositorie.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepositorie.saveAndFlush(user);
        }
        User user2 = userRepositorie.findByEmail(dto.getEmail());
        System.out.println(user2.getId());
        Movie movie = movieRepositorie.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()) {
            sum = sum + s.getValue();
        }
        int size = movie.getScores().size();
        double avg = sum / size;

        movie.setScore(avg);
        movie.setCount(size);

        movie = movieRepositorie.save(movie);

        return new MovieDTO(movie);
    }

}
