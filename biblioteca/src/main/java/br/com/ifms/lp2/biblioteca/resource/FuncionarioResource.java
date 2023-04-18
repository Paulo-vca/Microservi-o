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

import br.com.ifms.lp2.biblioteca.javabeans.Funcionario;
import br.com.ifms.lp2.biblioteca.repository.FuncionarioRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

public class FuncionarioResource {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Inserido Funcionario com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Funcionario salvarFuncionario(@RequestBody @Valid Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/funcionario/listarFuncionarios
    @GetMapping("/listarFuncionarios")
    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da Funcionario encontrado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/funcionario/Funcionarioid/2
    @GetMapping("/Funcionarioid/{id}")
    public Optional<Funcionario> buscaFuncionario(@PathVariable(value = "id") long id) {
        return funcionarioRepository.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do Funcionario removido com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/funcionario/remover/2
    @DeleteMapping(value = "/remover/{id}")
    public void deleteFuncionario(@PathVariable("id") long id) throws Exception {

        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if (funcionario.get().getIdFuncionario() > 0) {
            funcionarioRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID do Funcionario atulizado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/Funcionario/atualizar/2
    @PutMapping("/atualizar/{id}")
    public void atualizarFuncionario(@PathVariable(value = "id") long id, @RequestBody Funcionario novoFuncionario) {
        Optional<Funcionario> antigoFuncionario = funcionarioRepository.findById(id);

        if (antigoFuncionario.get().getIdFuncionario() > 0) {
            novoFuncionario.setIdFuncionario(antigoFuncionario.get().getIdFuncionario());
            funcionarioRepository.save(novoFuncionario);
        }
    }
}
