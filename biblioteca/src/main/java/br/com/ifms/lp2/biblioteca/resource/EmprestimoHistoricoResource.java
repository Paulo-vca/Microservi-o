package br.com.ifms.lp2.biblioteca.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.ifms.lp2.biblioteca.javabeans.EmprestimoHistorico;
import br.com.ifms.lp2.biblioteca.repository.EmprestimoHistoricoRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class EmprestimoHistoricoResource {
    @Autowired
    EmprestimoHistoricoRepository emprestimoHistoricoRepository;

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
})
// http://localhost:8080/api/emprestimoHistorico/listaremprestimoHistoricos
@GetMapping("/listaremprestimoHistoricos")
public List<EmprestimoHistorico> listaremprestimoHistorico() {
    return emprestimoHistoricoRepository.findAll();
}


}
