package edilton.chamados.dto;

import edilton.chamados.model.Assunto;
import edilton.chamados.model.Chamado;
import edilton.chamados.model.Status;
import edilton.chamados.repository.ChamadoRepository;
import edilton.chamados.repository.UsuarioRepository;

public class ChamadoForm {

	private Long id;
	private Assunto assunto;
	private Status status;
	private String complemento;
	
	
	
	public ChamadoForm(Chamado chamado) {
		this.id = chamado.getId();
		this.assunto = chamado.getAssunto();
		this.status = chamado.getStatus();
		this.complemento = chamado.getComplemento();
	}


	public ChamadoForm() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setNome(Assunto assunto) {
		this.assunto = assunto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public Chamado converter(UsuarioRepository usuarioRepository) {
		
		Chamado chamado=new Chamado();
		chamado.setId(id);
		chamado.setComplemento(complemento);
		chamado.setAssunto(assunto);
		//chamado.setUsuario(usuarioRepository.getById(usuario));
		chamado.setStatus(status);
		return chamado;
	}


	public Chamado atualiza(Long id, ChamadoRepository repository, UsuarioRepository usuarioRepository) {
		
		Chamado chamado= repository.getById(id);
		chamado.setId(id);
		chamado.setComplemento(complemento);
		//chamado.setUsuario(usuarioRepository.getById(usuario));
		chamado.setAssunto(assunto);
                chamado.setStatus(status);
		return chamado;
	}
	
}
