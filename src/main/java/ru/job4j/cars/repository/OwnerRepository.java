package ru.job4j.cars.repository;

import ru.job4j.cars.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {

    Owner save(Owner owner);

    boolean update(Integer id, Owner owner);

    boolean delete(int ownerId);

    List<Owner> findAll();

    Optional<Owner> findById(int ownerId);

}
