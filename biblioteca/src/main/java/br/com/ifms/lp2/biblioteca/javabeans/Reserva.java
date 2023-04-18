package br.com.ifms.lp2.biblioteca.javabeans;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
// @Table(name = "reservas")
public class Reserva {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "livro_id")
    private Livro livro;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Date dataReserva;

    public Reserva() {}

    public Reserva(Livro livro, Usuario usuario, Date dataReserva) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataReserva = dataReserva;
    }

    // getters e setters


    public Long getIdReserva() {
        return this.idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public Livro getLivro() {
        return this.livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataReserva() {
        return this.dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

}

