package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.File;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SqlFileRepositoryTest {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final FileRepository fileRepository = new SqlFileRepository(crudRepository);

    @Test
    public void whenSaveAndFileById() {
        File file = new File();
        fileRepository.save(file);
        assertThat(fileRepository.findById(file.getId()).get()).isEqualTo(file);
    }

    @Test
    public void whenDeleteById() {
        File file = new File();
        fileRepository.save(file);
        fileRepository.deleteById(file.getId());
        assertThatThrownBy(() -> fileRepository.findById(file.getId())).isInstanceOf(javax.persistence.NoResultException.class);
    }







}