package br.com.senai.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.teste.model.livro;

public interface LivroRepository extends JpaRepository <livro, Long> {
    
}
