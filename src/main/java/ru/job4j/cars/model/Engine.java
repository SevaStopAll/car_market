package ru.job4j.cars.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "engines")
public class Engine {
    private int id;
}