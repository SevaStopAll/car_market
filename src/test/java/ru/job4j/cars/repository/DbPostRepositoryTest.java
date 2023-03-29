package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DbPostRepositoryTest {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final PostRepository postRepository = new DbPostRepository(crudRepository);
    private final CarRepository carRepository = new DbCarRepository(crudRepository);
    private final EngineRepository engineRepository = new DbEngineRepository(crudRepository);
    private final UserRepository userRepository = new DbUserRepository(crudRepository);
    private final FileRepository fileRepository = new DbFileRepository(crudRepository);
    private final BodyRepository bodyRepository = new DbBodyRepository(crudRepository);
    private final TransmissionRepository transmissionRepository = new DbTransmissionRepository(crudRepository);
    @Test
    void whenFindByLastDay() {
        Post post = new Post();
        post.setDescription("Description");
        Car car = new Car();
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        Body body = new Body();
        body.setName("body");
        bodyRepository.save(body);
        Transmission transmission = new Transmission();
        transmission.setName("robot");
        transmissionRepository.save(transmission);
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        car.setBody(body);
        car.setTransmission(transmission);
        carRepository.save(car);
        File file = new File();
        fileRepository.save(file);
        post.setCar(car);
        User user = new User();
        user.setLogin("Login5");
        user.setPassword("Password5");
        userRepository.create(user);
        post.setUser(user);
        post.setCreated(LocalDateTime.now());
        post.setFile(fileRepository.findById(file.getId()).get());
        post.setPrice(100);
        postRepository.create(post);
        List<Post> expected = List.of(post);
        List<Post> rsl = postRepository.findByLastDay();
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindByPhoto() {
        Post post = new Post();
        post.setDescription("Description");
        Car car = new Car();
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        Body body = new Body();
        body.setName("body");
        bodyRepository.save(body);
        Transmission transmission = new Transmission();
        transmission.setName("mechanic");
        transmissionRepository.save(transmission);
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        car.setBody(body);
        car.setTransmission(transmission);
        carRepository.save(car);
        File file = new File();
        fileRepository.save(file);
        post.setCar(car);
        User user = new User();
        user.setLogin("Login5");
        user.setPassword("Password5");
        userRepository.create(user);
        post.setUser(user);
        post.setCreated(LocalDateTime.now());
        post.setFile(fileRepository.findById(file.getId()).get());
        post.setPrice(100);
        postRepository.create(post);
        List<Post> expected = List.of(post);
        List<Post> rsl = postRepository.findByPhoto();
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindByModel() {
        Post post = new Post();
        post.setDescription("Description");
        Car car = new Car();
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        Body body = new Body();
        body.setName("body");
        bodyRepository.save(body);
        Transmission transmission = new Transmission();
        transmission.setName("automatic");
        transmissionRepository.save(transmission);
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        car.setBody(body);
        car.setTransmission(transmission);
        carRepository.save(car);
        File file = new File();
        fileRepository.save(file);
        post.setCar(car);
        User user = new User();
        user.setLogin("Login5");
        user.setPassword("Password5");
        userRepository.create(user);
        post.setUser(user);
        post.setCreated(LocalDateTime.now());
        post.setFile(fileRepository.findById(file.getId()).get());
        post.setPrice(100);
        postRepository.create(post);
        List<Post> rsl = postRepository.findByModel(car.getName());
        List<Post> expected = List.of(post);
        assertThat(rsl).isEqualTo(expected);
    }
    @Test
    void whenFindAll() {
        Post post = new Post();
        post.setDescription("Description");
        Car car = new Car();
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        Body body = new Body();
        body.setName("body");
        bodyRepository.save(body);
        Transmission transmission = new Transmission();
        transmission.setName("hydro");
        transmissionRepository.save(transmission);
        car.setName("Car");
        car.setEngine(engine);
        car.setCreated(LocalDateTime.now());
        car.setBody(body);
        car.setTransmission(transmission);
        carRepository.save(car);
        File file = new File();
        fileRepository.save(file);
        post.setCar(car);
        User user = new User();
        user.setLogin("Login5");
        user.setPassword("Password5");
        userRepository.create(user);
        post.setUser(user);
        post.setCreated(LocalDateTime.now());
        post.setFile(fileRepository.findById(file.getId()).get());
        post.setPrice(100);
        postRepository.create(post);
        Post post2 = new Post();
        post2.setDescription("Description");
        Car car2 = new Car();
        Engine engine2 = new Engine();
        engine2.setName("Engine");
        engineRepository.save(engine2);
        Body body2 = new Body();
        body2.setName("body");
        bodyRepository.save(body2);
        Transmission transmission2 = new Transmission();
        transmission2.setName("chinese robot");
        transmissionRepository.save(transmission2);
        car2.setName("Car");
        car2.setEngine(engine);
        car2.setCreated(LocalDateTime.now());
        car2.setBody(body);
        car2.setTransmission(transmission);
        carRepository.save(car2);
        File file2 = new File();
        fileRepository.save(file2);
        post2.setCar(car2);
        User user2 = new User();
        user2.setLogin("Login5");
        user2.setPassword("Password5");
        userRepository.create(user2);
        post2.setUser(user2);
        post2.setCreated(LocalDateTime.now());
        post2.setFile(fileRepository.findById(file2.getId()).get());
        post2.setPrice(100);
        postRepository.create(post2);
        List<Post> rsl = postRepository.findAll();
        List<Post> expected = List.of(post, post2);
        assertThat(rsl).isEqualTo(expected);
    }
}