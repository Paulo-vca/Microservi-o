package br.com.ifms.lp2.biblioteca.javabeans;

import java.util.Date;

// @Entity
// @Table(name = "reservas")
public class Reserva {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

