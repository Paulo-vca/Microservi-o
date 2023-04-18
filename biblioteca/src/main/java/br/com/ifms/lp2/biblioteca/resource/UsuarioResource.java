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

    @ApiResponses(value = {
        @ApiResponse(code = 200, message = " Listado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
})
// http://localhost:8080/api/usuario/listarUsuarios
@GetMapping("/listarUsuarios")
public List<Usuario> listarUsuario() {
    return usuarioRepository.findAll();
}

@ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Usuario encontrado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
})
// http://localhost:8080/api/usuario/Usuarioid/2
@GetMapping("/Usuarioid/{id}")
public Optional<Usuario> buscaUsuario(@PathVariable(value = "id") long id) {
    return usuarioRepository.findById(id);
}

@ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID do Usuario removido com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
})
// http://localhost:8080/api/usuario/remover/2
@DeleteMapping(value = "/remover/{id}")
public void deleteUsuario(@PathVariable("id") long id) throws Exception {

    Optional<Usuario> usuario = usuarioRepository.findById(id);
    if (usuario.get().getIdUsuario() > 0) {
        usuarioRepository.deleteById(id);
    } else {
        System.out.println("não encontrado");
        throw new Exception("ID não encontrado!!!");
    }
}

@ApiResponses(value = {
        @ApiResponse(code = 200, message = " ID da Usuario atulizado com sucesso!!!"),
        @ApiResponse(code = 403, message = "Voçê não tem permissão para acessar este recurso"),
        @ApiResponse(code = 500, message = "Foi gerado uma exceção")
})
// http://localhost:8080/api/usuario/atualizar/2
@PutMapping("/atualizar/{id}")
public void atualizarUsuario(@PathVariable(value = "id") long id, @RequestBody Usuario novoUsuario) {
    Optional<Usuario> antigoUsuario = usuarioRepository.findById(id);

    if (antigoUsuario.get().getIdUsuario() > 0) {
        novoUsuario.setIdUsuario(antigoUsuario.get().getIdUsuario());
        usuarioRepository.save(novoUsuario);
    }
}
	
	
}
