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

import br.com.ifms.lp2.biblioteca.javabeans.Reserva;
import br.com.ifms.lp2.biblioteca.repository.LivroRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;

public class LivroResource {
    @Autowired
    LivroRepository livroRepository;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Inserido reserva com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    @PostMapping("/inserir")
    public Reserva salvarReserva(@RequestBody @Valid Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/reserva/listarReservas
    @GetMapping("/listarReservas")
    public List<Reserva> listarReserva() {
        return reservaRepository.findAll();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da reserva encontrado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/reserva/reservaid/2
    @GetMapping("/reservaid/{id}")
    public Optional<Reserva> buscaReserva(@PathVariable(value = "id") long id) {
        return reservaRepository.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da reserva removido com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/reserva/remover/2
    @DeleteMapping(value = "/remover/{id}")
    public void deleteReserva(@PathVariable("id") long id) throws Exception {

        Optional<Reserva> reserva = reservaRepository.findById(id);
        if (reserva.get().getIdReserva() > 0) {
            reservaRepository.deleteById(id);
        } else {
            System.out.println("não encontrado");
            throw new Exception("ID não encontrado!!!");
        }
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " ID da reserva atulizado com sucesso!!!"),
            @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerado uma exceção")
    })
    // http://localhost:8080/api/reserva/atualizar/2
    @PutMapping("/atualizar/{id}")
    public void atualizarReserva(@PathVariable(value = "id") long id, @RequestBody Reserva novaReserva) {
        Optional<Reserva> antigaReserva = reservaRepository.findById(id);

        if (antigaReserva.get().getIdReserva() > 0) {
            novaReserva.setIdReserva(antigaReserva.get().getIdReserva());
            reservaRepository.save(novaReserva);
        }
    }
}
