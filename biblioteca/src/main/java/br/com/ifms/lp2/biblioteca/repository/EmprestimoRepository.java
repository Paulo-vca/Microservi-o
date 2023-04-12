package br.com.ifms.lp2.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ifms.lp2.biblioteca.javabeans.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
    
}
