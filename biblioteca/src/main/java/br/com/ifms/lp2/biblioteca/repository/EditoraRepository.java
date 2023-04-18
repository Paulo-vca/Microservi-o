package br.com.ifms.lp2.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ifms.lp2.biblioteca.javabeans.Editora;


public interface EditoraRepository extends JpaRepository<Editora, Long> {
    
}
