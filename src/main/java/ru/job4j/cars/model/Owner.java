package ru.job4j.cars.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "owners")
public class Owner {
    private int id;
}
