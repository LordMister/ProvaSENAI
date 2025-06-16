package com.example.CatalogoLivros.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CatalogoLivros.Model.bibliotecarioModel;
import com.example.CatalogoLivros.Repository.bibliotecarioRepository;

@Service
public class bibliotecarioService {

    @Autowired
    private bibliotecarioRepository repository;

    public bibliotecarioModel registrar(bibliotecarioModel bibliotecario){
        return repository.save(bibliotecario);
    
    }

    public List<bibliotecarioModel> listar(){
       return repository.findAll();
        
    }

    public Optional<bibliotecarioModel> buscarID(Long id){
      return repository.findById(id);

    }

    public void Deletarbibliotecario (Long id){
       repository.deleteById(id);

    }

    public bibliotecarioModel atualizar (Long id, bibliotecarioModel bibliotecario){
       bibliotecario.setId(id);
       return repository.save(bibliotecario);

    }

}
