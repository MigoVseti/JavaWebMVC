package ru.ithub.js6c.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.js6c.models.Item;
import ru.ithub.js6c.models.Person;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
