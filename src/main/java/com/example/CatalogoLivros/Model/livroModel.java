package com.example.CatalogoLivros.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "livro")
@Getter
@Setter

public class livroModel {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;

    @ManyToOne
    @JoinColumn(name = "bibliotecario_id")
    private bibliotecarioModel bibliotecario;

    private String titulo;
    private String autor;
    private String genero;
    private String status;
    private Date data_cadastro;

}
