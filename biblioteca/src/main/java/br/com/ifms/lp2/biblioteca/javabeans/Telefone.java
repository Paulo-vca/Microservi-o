package br.com.ifms.lp2.biblioteca.javabeans;

// @Entity
public class Telefone {
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTelefone;
	private String numero;
	

    public long getIdTelefone() {
        return this.idTelefone;
    }

    public void setIdTelefone(long idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
	
}
