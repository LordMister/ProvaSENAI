package com.example.CatalogoLivros.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CatalogoLivros.Model.livroModel;

public interface livroRepository extends JpaRepository<livroModel, Long>{

}
