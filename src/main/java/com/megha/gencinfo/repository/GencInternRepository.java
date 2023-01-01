package com.megha.gencinfo.repository;

import com.megha.gencinfo.model.GencIntern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GencInternRepository extends JpaRepository<GencIntern ,Long> {
    GencIntern findById(long id);
}
