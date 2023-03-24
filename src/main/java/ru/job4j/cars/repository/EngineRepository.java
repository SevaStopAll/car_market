package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class EngineRepository {
    CrudRepository crudRepository;

    public List<Engine> findAll() {
        return crudRepository.query("from Engine", Engine.class);
    }

    public Engine findById(int id) {
        return crudRepository.optional(
                "from Engine where id = :fId", Engine.class,
                Map.of("fId", id)
        ).get();
    }
}
