package com.example.CatalogoLivros.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CatalogoLivros.Model.livroModel;
import com.example.CatalogoLivros.Repository.livroRepository;

@Service
public class livroService {

    @Autowired
    private livroRepository repository;

    public livroModel registrar(livroModel livro){
       return repository.save(livro);

    }

    public List<livroModel> listar(){
       return repository.findAll();

    }

    public Optional<livroModel> listarporID (Long id){
       return repository.findById(id);
        
    }

    public void Deletarlivro (Long id){
      repository.deleteById(id);
    }
    
    public livroModel atualizar(Long id, livroModel livromodel){
      livromodel.setId(id);
      return repository.save(livromodel);

    }
    
}
