package ru.ithub.js6c.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ithub.js6c.models.Zakaz;

public interface ZakazRepository  extends JpaRepository<Zakaz, Integer> {
}
