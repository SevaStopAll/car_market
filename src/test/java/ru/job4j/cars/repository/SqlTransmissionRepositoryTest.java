package ru.job4j.cars.repository;

import org.junit.jupiter.api.Test;
import ru.job4j.cars.configuration.HibernateConfiguration;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.model.Transmission;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class SqlTransmissionRepositoryTest {
    private final CrudRepository crudRepository = new SimpleCrudRepository(HibernateConfiguration.sf());
    private final TransmissionRepository transmissionRepository = new SqlTransmissionRepository(
            crudRepository);

    @Test
    public void whenSaveBrandsThenAllFound() {
        Transmission transmission1 = new Transmission();
        Transmission transmission2 = new Transmission();
        transmission1.setName("transmission1");
        transmission2.setName("transmission2");
        transmissionRepository.save(transmission1);
        transmissionRepository.save(transmission2);
        var result = transmissionRepository.findAll();
        assertThat(result).isEqualTo(List.of(transmission1, transmission2));
    }

    @Test
    void whenCreate() {
        Transmission transmission = new Transmission();
        transmission.setName("transmission1");
        transmissionRepository.save(transmission);
        Optional<Transmission> rsl = transmissionRepository.findById(transmission.getId());
        assertThat(rsl.get()).isEqualTo(transmission);
    }

    @Test
    void whenUpdate() {
        Transmission transmission = new Transmission();
        transmission.setName("transmission1");
        Transmission transmissionUpdate = new Transmission();
        transmissionUpdate.setName("transmission1");
        transmissionRepository.save(transmission);
        boolean rsl = transmissionRepository.update(transmission.getId(), transmissionUpdate);
        Optional<Transmission> rslUpdate = transmissionRepository.findById(transmission.getId());
        assertThat(rsl).isTrue();
        assertThat(rslUpdate.get().getName()).isEqualTo(transmissionUpdate.getName());
    }

    @Test
    void whenDelete() {
        Transmission transmission = new Transmission();
        transmission.setName("transmission1");
        transmissionRepository.save(transmission);
        boolean rsl = transmissionRepository.delete(transmission.getId());
        assertThat(rsl).isTrue();
    }

    @Test
    void whenFindAll() {
        Transmission transmission = new Transmission();
        transmission.setName("transmission1");
        transmissionRepository.save(transmission);
        List<Transmission> rsl = transmissionRepository.findAll();
        List<Transmission> expected = List.of(transmission);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenFindById() {
        Transmission transmission = new Transmission();
        transmission.setName("transmission1");
        transmissionRepository.save(transmission);
        Transmission rsl = transmissionRepository.findById(transmission.getId()).get();
        assertThat(rsl).isEqualTo(transmission);
    }

}