package com.s462050.pracownia_programowania.repository;

import com.s462050.pracownia_programowania.model.Samochod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamochodRepository extends JpaRepository<Samochod, Long> {
}
