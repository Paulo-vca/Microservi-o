package br.com.ifms.lp2.biblioteca.javabeans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    private String nome;

    private String email;

    public Autor() {
    }

    public Autor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    // getters e setters

    public Long getIdAutor() {
        return this.idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        
        this.email = email;
    }

}
