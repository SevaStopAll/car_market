package ru.job4j.cars.service;

import ru.job4j.cars.dto.PostDto;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> findByLastDay();
    List<Post> findByPhoto();
    List<Post> findByModel(String key);

    Post create(Post post);
    List<Post> findAll();

    Optional<Post> findById(int postId);

    void delete(int userId);

    List<Post> findDone(boolean sold);

    void setSold(int userId);

    void setUnsold(int userId);

    boolean update(Post post);
}
