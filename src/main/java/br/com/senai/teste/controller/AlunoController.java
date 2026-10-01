package br.com.senai.teste.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.senai.teste.service.AlunoService;

import org.springframework.web.bind.annotation.GetMapping
import br.com.senai.teste.model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController 
@RequestMapping("/alunos")
public class AlunoController {
    
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping 
    public ResponseEntity<Aluno> cadastrar(@RequestBody Aluno aluno) {
        Aluno alunoCadastrado = alunoService.cadastrar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        List<Aluno> alunos = alunoService.listar();
        return ResponseEntity.ok(alunos);

        
    }
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Integer id) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
        
}
