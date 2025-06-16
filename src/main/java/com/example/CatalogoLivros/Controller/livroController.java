package com.example.CatalogoLivros.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CatalogoLivros.Model.livroModel;
import com.example.CatalogoLivros.Service.livroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping ("/api/livros")
@CrossOrigin (origins = "*")
public class livroController {

    @Autowired
    private livroService service;

    @PostMapping
    public ResponseEntity<livroModel> registrarlivro (@RequestBody livroModel livro) {
            return ResponseEntity.ok(service.registrar(livro));
    }

    @GetMapping
    public ResponseEntity<List<livroModel>> listarlivro (){
            return ResponseEntity.ok(service.listar());
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<livroModel> listaID (@PathVariable Long id){
           return service.listarporID(id)
           .map(ResponseEntity::ok)
           .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<livroModel> atualizar (@PathVariable Long id, @RequestBody livroModel livro) {
          return ResponseEntity.ok(service.atualizar(id, livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarlivro (@PathVariable Long id){
          service.Deletarlivro(id);
          return ResponseEntity.noContent().build();
    }


}
