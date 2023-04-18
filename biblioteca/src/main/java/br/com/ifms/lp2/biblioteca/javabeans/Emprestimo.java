package br.com.ifms.lp2.biblioteca.javabeans;



import java.time.LocalDate;
import jakarta.persistence.Entity;

@Entity
public class Emprestimo {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private Long idLivro;
    private Long idUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    // construtor
    public Emprestimo(Long idEmprestimo, Long idLivro, Long idUsuario, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.idEmprestimo = idEmprestimo;
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    // getters e setters


    public Long getIdEmprestimo() {
        return this.idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Long getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

}

