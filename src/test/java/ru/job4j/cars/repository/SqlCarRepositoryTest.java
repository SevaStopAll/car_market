package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.model.Engine;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class SqlCarRepositoryTest {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final CarRepository carRepository = new SqlCarRepository(crudRepository);
    private final EngineRepository engineRepository = new SqlEngineRepository(crudRepository);

    @Test
    public void whenSaveAndFindById() {
        Engine engine = new Engine();
        engineRepository.save(engine);
        Car car = new Car();
        car.setEngine(engine);
        carRepository.save(car);
        assertThat(carRepository.findById(car.getId()).get()).isEqualTo(car);
    }

    @Test
    public void whenUpdate() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Car car = new Car();
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        engineRepository.save(engine);
        carRepository.save(car);
        Car carUpdate = new Car();
        carUpdate.setName("UpdatedCar");
        carUpdate.setCreated(LocalDateTime.now());
        boolean result = carRepository.update(car.getId(), carUpdate);
        Optional<Car> resultCar = carRepository.findById(car.getId());
        assertThat(result).isTrue();
        assertThat(resultCar.get().getName()).isEqualTo(carUpdate.getName());
    }

    @Test
    public void whenDelete() {
        Engine engine = new Engine();
        engineRepository.save(engine);
        Car car = new Car();
        car.setEngine(engine);
        carRepository.save(car);
        carRepository.delete(car.getId());
        assertThatThrownBy(() -> carRepository.findById(car.getId()).get()).isInstanceOf(javax.persistence.NoResultException.class);
    }

    @Test
    public void whenFindAll() {
        Engine engine = new Engine();
        engineRepository.save(engine);
        Car car = new Car();
        car.setEngine(engine);
        carRepository.save(car);
        assertThat(carRepository.findAll()).isEqualTo(List.of(car));
    }
}