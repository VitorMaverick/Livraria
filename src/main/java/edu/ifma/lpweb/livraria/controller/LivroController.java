package edu.ifma.lpweb.livraria.controller;

import edu.ifma.lpweb.livraria.model.Livro;
import edu.ifma.lpweb.livraria.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping
    public List<Livro> lista(String nome){
        if(nome == null){
            return livroService.todos();
        }else{
            return livroService.buscaPor(nome);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscaPor(@PathVariable Integer id){
        Optional<Livro> optional = livroService.buscaPor(id );
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }



}
