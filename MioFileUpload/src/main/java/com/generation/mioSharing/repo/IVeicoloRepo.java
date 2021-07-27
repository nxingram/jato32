package com.generation.mioSharing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.mioSharing.entity.Veicolo;


@Repository
public interface IVeicoloRepo extends JpaRepository<Veicolo, Integer> {

}
