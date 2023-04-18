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

import br.com.ifms.lp2.biblioteca.javabeans.Emprestimo;
import br.com.ifms.lp2.biblioteca.repository.EmprestimoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

public class EmprestimoResource {
    @Autowired
    EmprestimoRepository emprestimoRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Inserido emprestimo com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Emprestimo salvarEmprestimo(@RequestBody @Valid Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/emprestimo/listarEmprestimos
    @GetMapping("/listarEmprestimos")
    public List<Emprestimo> listarEmprestimo() {
        return emprestimoRepository.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do Emprestimo encontrado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/Emprestimo/Emprestimoid/2
    @GetMapping("/Emprestimoid/{id}")
    public Optional<Emprestimo> buscaEmprestimo(@PathVariable(value = "id") long id) {
        return emprestimoRepository.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da Emprestimo removido com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/Emprestimo/remover/2
    @DeleteMapping(value = "/remover/{id}")
    public void deleteEmprestimo(@PathVariable("id") long id) throws Exception {

        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
        if (emprestimo.get().getIdEmprestimo() > 0) {
            emprestimoRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do Emprestimo atulizado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/Emprestimo/atualizar/2
    @PutMapping("/atualizar/{id}")
    public void atualizarEmprestimo(@PathVariable(value = "id") long id, @RequestBody Emprestimo novoEmprestimo) {
        Optional<Emprestimo> antigoEmprestimo = emprestimoRepository.findById(id);

        if (antigoEmprestimo.get().getIdEmprestimo() > 0) {
            novoEmprestimo.setIdEmprestimo(antigoEmprestimo.get().getIdEmprestimo());
            emprestimoRepository.save(novoEmprestimo);
        }
    }
}
