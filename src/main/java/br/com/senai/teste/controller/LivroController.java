package br.com.senai.teste.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.senai.teste.service.LivroService;


import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.senai.teste.model.livro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.senai.teste.model.livro;
import jakarta.validation.Valid;


import java.util.List;

@RestController 
@RequestMapping("/livros")
public class LivroController {
    
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping 
    public ResponseEntity<livro> cadastrar(@Valid @RequestBody livro livro) {
        livro livroCadastrado = livroService.cadastrar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<livro>> listar() {
        List<livro> livros = livroService.listar();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<livro> buscarPorId(
        @PathVariable Integer id) {
        
        Optional<livro> livro = livroService.buscarPorId(id.longValue());

        if (livro.isPresent()) {
            return ResponseEntity.ok(livro.get());
        } 
            return ResponseEntity.notFound().build();
    }

    @PutMapping ("/{id}") 
    public ResponseEntity<livro> atualizar(
        @PathVariable Integer id, @RequestBody livro novosDados) {
        
        Optional<livro> livroAtualizado = livroService.atualizar(id, novosDados);

        if (livroAtualizado.isPresent()) {
            return ResponseEntity.ok(livroAtualizado.get());
        } 
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> excluir(
        @PathVariable Integer id) {

            boolean excluido = livroService.excluir(id);

            if (excluido) {
                return ResponseEntity.noContent().build();
            } 
                return ResponseEntity.notFound().build();
        }
}
