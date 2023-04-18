package br.com.ifms.lp2.biblioteca.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ifms.lp2.biblioteca.javabeans.Livro;
import br.com.ifms.lp2.biblioteca.repository.LivroRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

public class LivroResource {
    @Autowired
    LivroRepository livroRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Inserido Livro com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Livro salvarLivro(@RequestBody @Valid Livro livro) {
        return livroRepository.save(livro);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/livro/listarLivros
    @GetMapping("/listarLivros")
    public List<Livro> listarLivro() {
        return livroRepository.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do Livro encontrado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/livro/Livroid/2
    @GetMapping("/Livroid/{id}")
    public Optional<Livro> buscaLivro(@PathVariable(value = "id") long id) {
        return livroRepository.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do Livro removido com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/livro/remover/2
    @DeleteMapping(value = "/remover/{id}")
    public void deleteLivro(@PathVariable("id") long id) throws Exception {

        Optional<Livro> Livro = livroRepository.findById(id);
        if (Livro.get().getIdLivro() > 0) {
            livroRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da Livro atulizado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/livro/atualizar/2
    @PutMapping("/atualizar/{id}")
    public void atualizarLivro(@PathVariable(value = "id") long id, @RequestBody Livro novoLivro) {
        Optional<Livro> antigoLivro = livroRepository.findById(id);

        if (antigoLivro.get().getIdLivro() > 0) {
            novoLivro.setIdLivro(antigoLivro.get().getIdLivro());
            livroRepository.save(novoLivro);
        }
    }
}
