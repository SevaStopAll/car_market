package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Body;
import ru.job4j.cars.repository.DbBodyRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleBodyService implements BodyService {
    private final DbBodyRepository bodyRepository;

    @Override
    public Body save(Body body) {
        return bodyRepository.save(body);
    }

    @Override
    public boolean update(Integer id, Body body) {
        return bodyRepository.update(id, body);
    }

    @Override
    public boolean delete(int bodyId) {
        return bodyRepository.delete(bodyId);
    }

    @Override
    public List<Body> findAll() {
        return bodyRepository.findAll();
    }

    @Override
    public Optional<Body> findById(int bodyId) {
        return bodyRepository.findById(bodyId);
    }
}
