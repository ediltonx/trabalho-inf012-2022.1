package edilton.chamados.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "chamados")

public class Chamado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String complemento;
        
	@ManyToOne
	private Usuario usuario;
		
	@Enumerated(EnumType.STRING)
	private Assunto assunto;
        
        @Enumerated(EnumType.STRING)
	private Status status;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Assunto getAssunto() {
		return assunto;
	}
	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}
	        
        public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
        
        public Usuario getUsuario() {
          
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
	
}
