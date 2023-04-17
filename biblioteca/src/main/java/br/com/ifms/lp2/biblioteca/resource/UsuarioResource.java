package br.com.ifms.lp2.biblioteca.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.lp2.biblioteca.javabeans.Usuario;
import br.com.ifms.lp2.biblioteca.repository.UsuarioRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;


@RestController
@RequestMapping(value="api/usuario")

public class UsuarioResource {
    @Autowired
    UsuarioRepository usuarioRepository;


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Inserido Usuario com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
})
    @PostMapping("/inserir")
	public Usuario salvarUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
}
