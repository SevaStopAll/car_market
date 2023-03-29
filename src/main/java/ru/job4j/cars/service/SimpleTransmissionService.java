package ru.job4j.cars.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.cars.model.Transmission;
import ru.job4j.cars.repository.DbTransmissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleTransmissionService implements TransmissionService {
    private final DbTransmissionRepository transmissionRepository;
    @Override
    public Transmission save(Transmission transmission) {
        return transmissionRepository.save(transmission);
    }

    @Override
    public boolean update(Integer id, Transmission transmission) {
        return transmissionRepository.update(id, transmission);
    }

    @Override
    public boolean delete(int transmissionId) {
        return transmissionRepository.delete(transmissionId);
    }

    @Override
    public List<Transmission> findAll() {
        return transmissionRepository.findAll();
    }

    @Override
    public Optional<Transmission> findById(int transmissionId) {
        return transmissionRepository.findById(transmissionId);
    }
}
