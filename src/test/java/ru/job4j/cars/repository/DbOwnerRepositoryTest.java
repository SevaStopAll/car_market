package ru.job4j.cars.repository;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.cars.model.Owner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DbOwnerRepositoryTest {
    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(REGISTRY)
            .buildMetadata().buildSessionFactory();

    private final CrudRepository crudRepository = new SimpleCrudRepository(sf);
    private final OwnerRepository ownerRepository = new SqlOwnerRepository(crudRepository);

    @Test
    public void whenSave() {
        Owner owner = new Owner();
        ownerRepository.save(owner);
        assertThat(ownerRepository.findById(owner.getId()).get()).isEqualTo(owner);
    }

    @Test
    public void whenUpdate() {
        Owner owner = new Owner();
        Owner owner2 = new Owner();
        owner2.setName("aaaa");
        ownerRepository.save(owner);
        ownerRepository.update(owner.getId(), owner2);
        assertThat(ownerRepository.findById(owner.getId()).get().getName()).isEqualTo("aaaa");
    }

    @Test
    public void whenDelete() {
        Owner owner = new Owner();
        ownerRepository.save(owner);
        ownerRepository.delete(owner.getId());
        assertThatThrownBy(() -> ownerRepository.findById(owner.getId())).isInstanceOf(javax.persistence.NoResultException.class);
    }

    @Test
    public void whenFindAll() {
        Owner owner = new Owner();
        ownerRepository.save(owner);
        assertThat(ownerRepository.findAll()).isEqualTo(List.of(owner));
    }

    @Test
    public void whenFindById() {
        Owner owner = new Owner();
        ownerRepository.save(owner);
        assertThat(ownerRepository.findById(owner.getId()).get()).isEqualTo(owner);
    }

}