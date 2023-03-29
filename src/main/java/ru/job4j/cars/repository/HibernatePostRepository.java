package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernatePostRepository implements PostRepository {
    private static final String FIND_BY_LAST_DAY = "FROM Post p JOIN FETCH p.car JOIN FETCH p.car.engine JOIN FETCH p.car.body JOIN FETCH p.car.transmission JOIN FETCH p.file WHERE p.created BETWEEN :fCreatedBefore AND :fCreatedAfter";
    private static final String FIND_BY_PHOTO = "FROM Post p JOIN FETCH p.car JOIN FETCH p.car.engine JOIN FETCH p.car.body JOIN FETCH p.car.transmission JOIN FETCH p.file WHERE p.file.id != 10";
    private static final String FIND_BY_MODEL = "FROM Post p JOIN FETCH p.car JOIN FETCH p.car.engine JOIN FETCH p.car.body JOIN FETCH p.car.transmission JOIN FETCH p.file WHERE p.car.name = :fName";
    private static final String FIND_ALL = "FROM Post p JOIN FETCH p.car JOIN FETCH p.car.engine JOIN FETCH p.car.body JOIN FETCH p.car.transmission JOIN FETCH p.file";
    private static final String FIND_BY_ID = "FROM Post p JOIN FETCH p.car JOIN FETCH p.car.engine JOIN FETCH p.car.body JOIN FETCH p.car.transmission JOIN FETCH p.file WHERE p.id = :fId";
    private static final String DELETE = "DELETE FROM Post p JOIN FETCH p.car WHERE p.id = :fId";
    private static final String FIND_BY_SOLD = "FROM Post p JOIN FETCH p.car JOIN FETCH p.car.engine JOIN FETCH p.car.body JOIN FETCH p.car.transmission JOIN FETCH p.file WHERE p.sold = :fSold";
    private static final String SET_SOLD = "FROM Post p JOIN FETCH p.car SET p.sold = :fSold WHERE p.id = :fId";
    private static final String SET_UNSOLD = "UPDATE Post p JOIN FETCH p.car SET p.sold = :fSold WHERE p.id = :fId";


    private final CrudRepository crudRepository;

    /**
     * Найти объявление за предыдущий день.
     *
     * @return список с объявлениями.
     */
    @Override
    public List<Post> findByLastDay() {
        LocalDateTime beforePeriod = LocalDateTime.now().minusHours(24);
        LocalDateTime afterPeriod = LocalDateTime.now();
        return crudRepository.query(FIND_BY_LAST_DAY, Post.class,
                Map.of("fCreatedBefore", beforePeriod,
                        "fCreatedAfter", afterPeriod)
        );
    }

    /**
     * Найти объявление с фото.
     *
     * @return список с объявлениями.
     */
    @Override
    public List<Post> findByPhoto() {
        return crudRepository.query(FIND_BY_PHOTO, Post.class);
    }

    /**
     * Найти объявление по названию машины.
     *
     * @param key название машины.
     * @return список с объявлениями.
     */
    @Override
    public List<Post> findByModel(String key) {
        return crudRepository.query(FIND_BY_MODEL, Post.class, Map.of("fName", key));
    }

    /**
     * Сохранить в базе.
     *
     * @param post объявление.
     * @return объявление с id.
     */
    @Override
    public Post create(Post post) {
        crudRepository.run(session -> session.persist(post));
        return post;
    }

    /**
     * Найти объявление за предыдущий день.
     *
     * @return список с объявлениями.
     */
    @Override
    public boolean update(Post post) {
        crudRepository.run(session -> session.merge(post));
        return true;
    }

    /**
     * Лист всех объявлений
     *
     * @return список объявлений.
     */
    @Override
    public List<Post> findAll() {
        return crudRepository.query(FIND_ALL, Post.class);
    }

    /**
     * Найти объявление по ID
     *
     * @return объявление.
     */
    @Override
    public Optional<Post> findById(int postId) {
        return crudRepository.optional(
                FIND_BY_ID, Post.class,
                Map.of("fId", postId)
        );
    }

    /**
     * Найти объявление по ID
     * @param userId объявления.
     *
     * @return объявление.
     */
    @Override
    public void delete(int userId) {
        crudRepository.run(
                DELETE, Map.of("fId", userId));
    }

    /**
     * Найти объявления активные/не активные
     * @param sold нужный пользователю статус true - машина продана \ false - машина еще продается.
     *
     * @return объявление.
     */
    @Override
    public List<Post> findDone(boolean sold) {
        return crudRepository.query(
                FIND_BY_SOLD, Post.class,
                Map.of("fSold", sold)
        );
    }

    /**
     * Поменять статус объявления на "Продано"
     * @param postId номер поста.
     *
     */
    @Override
    public void setSold(int postId) {
        crudRepository.run(
                SET_SOLD, Map.of("fId", postId));
    }

    /**
     * Поменять статус объявление на "Активно"
     * @param postId номер поста.
     *
     */
    @Override
    public void setUnsold(int postId) {
        crudRepository.run(
                DELETE, Map.of("fId", postId));
    }

}
