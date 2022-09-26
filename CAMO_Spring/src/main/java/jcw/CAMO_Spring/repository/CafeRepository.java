package jcw.CAMO_Spring.repository;

import jcw.CAMO_Spring.domain.Cafe;

import java.util.Optional;

public interface CafeRepository {

    Cafe save(Cafe cafe);
    Optional<Cafe> findById(Long id);
    Optional<Cafe> findByName(String name);
}
