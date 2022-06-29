package edilton.chamados.dto;

import org.springframework.data.domain.Page;

import edilton.chamados.model.Assunto;
import edilton.chamados.model.Chamado;
import edilton.chamados.model.Status;

public class ChamadoDto {
    
	private Long id;
	private Assunto assunto;
	private Status status;
	private String complemento;
        private String nomeUsuario;
	
	public ChamadoDto(Chamado chamado) {
		
		this.id = chamado.getId();
		this.assunto = chamado.getAssunto();
		this.status = chamado.getStatus();
		this.complemento = chamado.getComplemento();
                this.nomeUsuario = chamado.getUsuario().getNome();
	}
	
	public static Page<ChamadoDto> converte(Page<Chamado> page){
		
		//List<PostDto> listaDto=new ArrayList<>();
		//for (int i=0; i<lista.size();i++) {
		//	listaDto.add(new ChamadoDto(lista.get(i)));
		//}
		return page.map(ChamadoDto::new);
	
	
	}
	
	public ChamadoDto() {
		
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario; }
}

	
	
