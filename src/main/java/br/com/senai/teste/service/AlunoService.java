package br.com.senai.teste.service;

import org.springframework.stereotype.Service;

import java.util.List;
import br.com.senai.teste.model.Aluno;
import br.com.senai.teste.repository.AlunoRepository;

@Service 
public class AlunoService {
    
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno cadastrar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }
}
