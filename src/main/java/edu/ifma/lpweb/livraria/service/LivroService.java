package edu.ifma.lpweb.livraria.service;

import edu.ifma.lpweb.livraria.model.Livro;
import edu.ifma.lpweb.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> todos() {
        return livroRepository.findAll();
    }

    public List<Livro> buscaPor(String nome ) {
        return livroRepository.findByNomeContaining(nome );
    }

    public Livro salva(Livro livro) {
        return livroRepository.save(livro);
    }

    public Optional<Livro> buscaPor(Integer id) {
        return livroRepository.findById(id );
    }
}
