package ru.job4j.cars.repository;

import org.junit.jupiter.api.Test;
import ru.job4j.cars.configuration.HibernateConfiguration;
import ru.job4j.cars.model.Body;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class HibernateBodyRepositoryTest {
    private final CrudRepository crudRepository = new SimpleCrudRepository(HibernateConfiguration.sf());
    private final BodyRepository bodyRepository = new HibernateBodyRepository(
            crudRepository);

    @Test
    public void whenSaveBrandsThenAllFound() {
        Body body1 = new Body();
        Body body2 = new Body();
        body1.setName("Body1");
        body2.setName("Body2");
        bodyRepository.save(body1);
        bodyRepository.save(body2);
        var result = bodyRepository.findAll();
        assertThat(result).isEqualTo(List.of(body1, body2));
    }

    @Test
    void whenCreate() {
        Body body = new Body();
        body.setName("Body");
        bodyRepository.save(body);
        Optional<Body> rsl = bodyRepository.findById(body.getId());
        assertThat(rsl.get()).isEqualTo(body);
    }

    @Test
    void whenUpdate() {
        Body engine = new Body();
        engine.setName("Body");
        Body engineUpdate = new Body();
        engineUpdate.setName("Body");
        bodyRepository.save(engine);
        boolean rsl = bodyRepository.update(engine.getId(), engineUpdate);
        Optional<Body> rslUpdate = bodyRepository.findById(engine.getId());
        assertThat(rsl).isTrue();
        assertThat(rslUpdate.get().getName()).isEqualTo(engineUpdate.getName());
    }

    @Test
    void whenDelete() {
        Body engine = new Body();
        engine.setName("Body");
        bodyRepository.save(engine);
        boolean rsl = bodyRepository.delete(engine.getId());
        assertThat(rsl).isTrue();
    }

    @Test
    void whenFindAll() {
        Body engine = new Body();
        engine.setName("Body");
        bodyRepository.save(engine);
        List<Body> rsl = bodyRepository.findAll();
        List<Body> expected = List.of(engine);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindById() {
        Body engine = new Body();
        engine.setName("Body");
        bodyRepository.save(engine);
        Body rsl = bodyRepository.findById(engine.getId()).get();
        assertThat(rsl).isEqualTo(engine);
    }

}