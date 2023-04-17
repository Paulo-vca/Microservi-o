package br.com.ifms.lp2.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifms.lp2.biblioteca.javabeans.EmprestimoHistorico;

@Repository
public interface EmprestimoHistoricoRepository extends JpaRepository <EmprestimoHistorico, Long>{
    
}
