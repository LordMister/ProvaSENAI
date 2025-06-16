package com.example.CatalogoLivros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CatalogoLivros.Model.bibliotecarioModel;

@Repository
public interface bibliotecarioRepository extends JpaRepository<bibliotecarioModel, Long> {

}
