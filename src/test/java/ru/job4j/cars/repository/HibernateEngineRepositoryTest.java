package ru.job4j.cars.repository;

import org.junit.jupiter.api.Test;
import ru.job4j.cars.configuration.HibernateConfiguration;
import ru.job4j.cars.model.Engine;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class HibernateEngineRepositoryTest {
    private final CrudRepository crudRepository = new SimpleCrudRepository(HibernateConfiguration.sf());
    private final EngineRepository engineRepository = new HibernateEngineRepository(
            crudRepository);

    @Test
    public void whenSaveBrandsThenAllFound() {
        Engine engine1 = new Engine();
        Engine engine2 = new Engine();
        engine1.setName("engine1");
        engine2.setName("engine2");
        engineRepository.save(engine1);
        engineRepository.save(engine2);
        var result = engineRepository.findAll();
        assertThat(result).isEqualTo(List.of(engine1, engine2));
    }

    @Test
    void whenCreate() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        Optional<Engine> rsl = engineRepository.findById(engine.getId());
        assertThat(rsl.get()).isEqualTo(engine);
    }

    @Test
    void whenUpdate() {
        Engine engine = new Engine();
        engine.setName("Engine");
        Engine engineUpdate = new Engine();
        engineUpdate.setName("Engine");
        engineRepository.save(engine);
        boolean rsl = engineRepository.update(engine.getId(), engineUpdate);
        Optional<Engine> rslUpdate = engineRepository.findById(engine.getId());
        assertThat(rsl).isTrue();
        assertThat(rslUpdate.get().getName()).isEqualTo(engineUpdate.getName());
    }

    @Test
    void whenDelete() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        boolean rsl = engineRepository.delete(engine.getId());
        assertThat(rsl).isTrue();
    }

    @Test
    void whenFindAll() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        List<Engine> rsl = engineRepository.findAll();
        List<Engine> expected = List.of(engine);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindById() {
        Engine engine = new Engine();
        engine.setName("Engine");
        engineRepository.save(engine);
        Engine rsl = engineRepository.findById(engine.getId()).get();
        assertThat(rsl).isEqualTo(engine);
    }
}