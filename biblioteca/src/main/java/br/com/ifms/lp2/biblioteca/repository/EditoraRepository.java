package br.com.ifms.lp2.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ifms.lp2.biblioteca.javabeans.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    
}
