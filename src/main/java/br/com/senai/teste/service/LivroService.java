package br.com.senai.teste.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import br.com.senai.teste.model.livro;
import br.com.senai.teste.repository.LivroRepository;

@Service 
public class LivroService {
    

    private final LivroRepository LivroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.LivroRepository = livroRepository;
    }

    public livro cadastrar(livro livro) {
        return LivroRepository.save(livro);
    }

    public List<livro> listar() {
        return LivroRepository.findAll();
    }

    public Optional<livro> buscarPorId(Long id) {
        return LivroRepository.findById(id);
    }

    public Optional<livro> atualizar(
        Integer id, livro novosDados) {

        Optional<livro> livroExistente = LivroRepository.findById(id.longValue());

        if (livroExistente.isEmpty()) {
            return Optional.empty();
        }

        livro livro = livroExistente.get();

        livro.setTitulo(novosDados.getTitulo());
        livro.setAutor(novosDados.getAutor());
        livro.setAnoPublicacao(novosDados.getAnoPublicacao());

        return Optional.of(LivroRepository.save(livro));
}

public boolean excluir(Integer id) {

    if (!LivroRepository.existsById(id.longValue())) {
        return false;
    }

    LivroRepository.deleteById(id.longValue());
    return true;

}


}
