package edu.ifma.lpweb.livraria.repository;

import edu.ifma.lpweb.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByNomeContaining(String nome);
}
