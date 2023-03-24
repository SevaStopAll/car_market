package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class PostRepository {
    private final CrudRepository crudRepository;

    public List<Post> findByCar(String car) {
        return crudRepository.query(
                "from Post AS p JOIN FETCH p.cars where name = :fCar", Post.class,
                Map.of("fCar", car)
        );
    }

    public List<Post> findLastDay() {
        return crudRepository.query(
                "from Post AS p JOIN FETCH p.cars where auto_post.created > :fDate", Post.class,
        Map.of("fDate", LocalDateTime.now().minusDays(1))
        );
    }

    public List<Post> findWithPhotos() {
        return crudRepository.query(
                "from Post AS p JOIN FETCH p.cars JOIN FETCH p.files where post_id is not null", Post.class);
    }
}
