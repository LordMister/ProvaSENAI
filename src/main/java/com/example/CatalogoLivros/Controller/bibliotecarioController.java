package com.example.CatalogoLivros.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CatalogoLivros.Model.bibliotecarioModel;
import com.example.CatalogoLivros.Service.bibliotecarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping ("/api/bibliotecario")
@CrossOrigin (origins = "*")
public class bibliotecarioController {

    @Autowired
    private bibliotecarioService service;

    @PostMapping
    public ResponseEntity<bibliotecarioModel> registrarBibliotecario(@RequestBody bibliotecarioModel bibliotecarioModel){
        return ResponseEntity.ok(service.registrar(bibliotecarioModel));
    }

    @GetMapping
    public ResponseEntity<List<bibliotecarioModel>> listar(){
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<bibliotecarioModel> buscarporID (@PathVariable Long id){
      return service.buscarID(id)
     .map(ResponseEntity::ok)
     .orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")  
    public ResponseEntity <Void> deletarbibliotecario (@PathVariable Long id){
        service.Deletarbibliotecario(id);
        return (ResponseEntity.noContent().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<bibliotecarioModel> atualizar (@PathVariable Long id, @RequestBody bibliotecarioModel bibliotecario){
        return ResponseEntity.ok(service.atualizar(id, bibliotecario));
    }
      
}
