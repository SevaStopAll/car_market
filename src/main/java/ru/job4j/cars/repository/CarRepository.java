package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class CarRepository {
    private final CrudRepository crudRepository;


    public Car add(Car car) {
        crudRepository.run(session -> session.persist(car));
        return car;
    }

    public boolean replace(Car car) {
        crudRepository.run(session -> session.merge(car));
        return true;
    }

    public boolean delete(int id) {
        crudRepository.run(
                "delete from Car where id = :fId",
                Map.of("fId", id)
        );
        return true;
    }


    public List<Car> findAll() {
        return crudRepository.query("from Car AS c JOIN FETCH c.owners JOIN FETCH c.engine", Car.class);
    }


    public Car findById(int id) {
        return crudRepository.optional(
                "from Car AS c JOIN FETCH c.owners JOIN FETCH c.engine where c.id = :fId", Car.class,
                Map.of("fId", id)
        ).get();
    }

}
