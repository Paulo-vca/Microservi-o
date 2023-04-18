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

import br.com.ifms.lp2.biblioteca.javabeans.Editora;
import br.com.ifms.lp2.biblioteca.repository.EditoraRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

public class EditoraResource {
    @Autowired
    EditoraRepository editoraRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Inserido editora com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Editora salvarEditora(@RequestBody @Valid Editora editora) {
        return editoraRepository.save(editora);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/editora/listarEditoras
    @GetMapping("/listarEditoras")
    public List<Editora> listarEditoras() {
        return editoraRepository.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da editora encontrado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/editora/editoraid/2
    @GetMapping("/editoraid/{id}")
    public Optional<Editora> buscaEditora(@PathVariable(value = "id") long id) {
        return editoraRepository.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da editora removido com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/editora/remover/2
    @DeleteMapping(value = "/remover/{id}")
    public void deleteEditora(@PathVariable("id") long id) throws Exception {

        Optional<Editora> editora = editoraRepository.findById(id);
        if (editora.get().getIdEditora() > 0) {
            editoraRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da editora atulizado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/editora/atualizar/2
    @PutMapping("/atualizar/{id}")
    public void atualizarEditora(@PathVariable(value = "id") long id, @RequestBody Editora novaEditora) {
        Optional<Editora> antigaEditora = editoraRepository.findById(id);

        if (antigaEditora.get().getIdEditora() > 0) {
            novaEditora.setIdEditora(antigaEditora.get().getIdEditora());
            editoraRepository.save(novaEditora);
        }
    }
}
