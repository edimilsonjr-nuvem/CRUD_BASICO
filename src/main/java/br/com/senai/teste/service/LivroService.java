package br.com.senai.teste.service;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import br.com.senai.teste.model.Livro;
import br.com.senai.teste.repository.LivroRepository;

@Service 
public class LivroService {
    

    private final LivroRepository LivroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.LivroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {
        return LivroRepository.save(livro);
    }

    public List<Livro> listar() {
        return LivroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Integer id) {
        return LivroRepository.findById(id);
    }

    public Optional<Livro> atualizar(
        Integer id, Livro novosDados) {

        Optional<Livro> livroExistente = LivroRepository.findById(id.intValue());

        if (livroExistente.isEmpty()) {
            return Optional.empty();
        }

        Livro livro = livroExistente.get();

        livro.setTitulo(novosDados.getTitulo());
        livro.setAutor(novosDados.getAutor());
        livro.setAnoPublicacao(novosDados.getAnoPublicacao());

        return Optional.of(LivroRepository.save(livro));
}

public boolean excluir(Integer id) {

    if (!LivroRepository.existsById(id.intValue())) {
        return false;
    }

    LivroRepository.deleteById(id.intValue());
    return true;

}


}
