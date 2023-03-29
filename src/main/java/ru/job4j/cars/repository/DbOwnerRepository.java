package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import ru.job4j.cars.model.Owner;


import java.util.List;
import java.util.Map;
import java.util.Optional;


@Repository
@AllArgsConstructor
public class DbOwnerRepository implements OwnerRepository {

    private static final String UPDATE = "UPDATE Owner SET name = :fName WHERE id = :fId";
    private static final String DELETE = "DELETE FROM Owner WHERE id = :fId";
    private static final String FIND_ALL = "FROM Owner";
    private static final String FIND_BY_ID = "FROM Owner WHERE id = :fId";
    private final CrudRepository crudRepository;

    /**
     * Сохранить в базе.
     *
     * @param owner водитель.
     * @return водитель с id.
     */
    @Override
    public Owner save(Owner owner) {
        crudRepository.run(session -> session.persist(owner));
        return owner;
    }

    /**
     * Обновить в базе водителя.
     *
     * @param owner водитель.
     */
    @Override
    public boolean update(Integer id, Owner owner) {
        return crudRepository.booleanQuery(UPDATE,
                Map.of("fName", owner.getName(),
                        "fId", id)
        );
    }

    /**
     * Удалить водителя по id.
     *
     * @param ownerId ID
     */
    @Override
    public boolean delete(int ownerId) {
        return crudRepository.booleanQuery(DELETE, Map.of("fId", ownerId));
    }

    /**
     * Список всех водителей
     *
     * @return список водителей.
     */
    @Override
    public List<Owner> findAll() {
        return crudRepository.query(FIND_ALL, Owner.class);
    }

    /**
     * Найти водителя по ID
     *
     * @return водитель.
     */
    @Override
    public Optional<Owner> findById(int ownerId) {
        return crudRepository.optional(
                FIND_BY_ID, Owner.class,
                Map.of("fId", ownerId)
        );
    }
}
