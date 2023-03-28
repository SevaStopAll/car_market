package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.dto.PostDto;
import ru.job4j.cars.model.Post;
import ru.job4j.cars.repository.SqlCarRepository;
import ru.job4j.cars.repository.SqlPostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimplePostService implements PostService{
    private final SqlPostRepository postRepository;
    private final SqlCarRepository carRepository;
    private final SimpleFileService fileService;

    @Override
    public Post create(Post post) {
        return postRepository.create(post);
    }
    @Override
    public List<Post> findByLastDay() {
        return postRepository.findByLastDay();
    }

    @Override
    public List<Post> findByPhoto() {
        return postRepository.findByPhoto();
    }

    @Override
    public List<Post> findByModel(String key) {
        return postRepository.findByModel(key);
    }


    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(int postId) {
        return postRepository.findById(postId);
    }

    @Override
    public void delete(int userId) {
        postRepository.delete(userId);
    }

    @Override
    public List<Post> findDone(boolean sold) {
        return postRepository.findDone(sold);
    }

    @Override
    public void setSold(int userId) {
        postRepository.setSold(userId);
    }

    @Override
    public void setUnsold(int userId) {
        postRepository.setUnsold(userId);
    }
}
