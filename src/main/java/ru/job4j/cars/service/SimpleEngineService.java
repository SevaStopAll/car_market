package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Engine;
import ru.job4j.cars.repository.SqlEngineRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleEngineService implements EngineService {
    private final SqlEngineRepository engineRepository;
    @Override
    public Engine save(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public boolean delete(int engineId) {
        return engineRepository.delete(engineId);
    }

    @Override
    public boolean update(Integer id, Engine engine) {
        return engineRepository.update(id, engine);
    }

    @Override
    public List<Engine> findAll() {
        return engineRepository.findAll();
    }

    @Override
    public Optional<Engine> findById(int engineId) {
        return engineRepository.findById(engineId);
    }
}
