package ru.job4j.cars.service;

import ru.job4j.cars.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    Owner save(Owner owner);

    boolean update(Integer id, Owner owner);

    boolean delete(int ownerId);

    List<Owner> findAll();

    Optional<Owner> findById(int ownerId);

}
