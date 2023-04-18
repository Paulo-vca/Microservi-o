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

import br.com.ifms.lp2.biblioteca.javabeans.Autor;
import br.com.ifms.lp2.biblioteca.repository.AutorRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid; 

public class AutorResource {
    @Autowired
    AutorRepository autorRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Inserido autor com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Autor salvarAutor(@RequestBody @Valid Autor autor) {
        return autorRepository.save(autor);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/autor/listarAutores
    @GetMapping("/listarAutores")
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do autor encontrado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/autor/autorid/2
    @GetMapping("/autorid/{id}")
    public Optional<Autor> buscaAutor(@PathVariable(value = "id") long id) {
        return autorRepository.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do autor removido com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/autor/remover/2
    @DeleteMapping(value = "/remover/{id}")
    public void deleteAutor(@PathVariable("id") long id) throws Exception {

        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.get().getIdAutor() > 0) {
            autorRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do autor atulizado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/autor/atualizar/2
    @PutMapping("/atualizar/{id}")
    public void atualizarAutor(@PathVariable(value = "id") long id, @RequestBody Autor novoAutor) {
        Optional<Autor> antigoAutor = autorRepository.findById(id);

        if (antigoAutor.get().getIdAutor() > 0) {
            novoAutor.setIdAutor(antigoAutor.get().getIdAutor());
            autorRepository.save(novoAutor);
        }
    }
}
