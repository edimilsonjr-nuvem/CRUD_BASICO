package br.com.senai.teste.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
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

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Optional<Aluno> atualizar(
        Integer id, Aluno novosDados) {

        Optional<Aluno> alunoExistente = alunoRepository.findById(id.longValue());

        if (alunoExistente.isEmpty()) {
            return Optional.empty();
        }

        Aluno aluno = alunoExistente.get();

        aluno.setNome(novosDados.getNome());
        aluno.setEmail(novosDados.getEmail());

        return Optional.of(alunoRepository.save(aluno));
}

public boolean excluir(Integer id) {

    if (!alunoRepository.existsById(id.longValue())) {
        return false;
    }

    alunoRepository.deleteById(id.longValue());
    return true;

}

}
