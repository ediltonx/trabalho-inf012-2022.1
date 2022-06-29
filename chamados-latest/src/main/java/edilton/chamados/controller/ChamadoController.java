package edilton.chamados.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import edilton.chamados.dto.ChamadoDto;
import edilton.chamados.dto.ChamadoForm;
import edilton.chamados.model.Chamado;
import edilton.chamados.repository.UsuarioRepository;
import edilton.chamados.repository.ChamadoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/chamados")
@CrossOrigin(origins = "http://localhost:3000")
public class ChamadoController {

	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public Page<ChamadoDto> listar(@RequestParam(required = false) Long id, Pageable pageable){
		
		//Pageable pageable = PageRequest.of(pagina, qtd);
		
		if(id==null){
		} else {
                    return ChamadoDto.converte(repository.findById(id,pageable));
            }
		
		return ChamadoDto.converte(repository.findAll(pageable));	
	}
	
      /*public Page<ChamadoDto> list(@RequestParam(required = false) String nomeUsuario, Pageable pageable){
		
		//Pageable pageable = PageRequest.of(pagina, qtd);
		
		if((nomeUsuario!=null) && (!nomeUsuario.equals(""))) {
			return ChamadoDto.converte(repository.findByName(nomeUsuario,pageable));
		}
		
		return ChamadoDto.converte(repository.findAll(pageable));	
	}*/  // ver pq nao pega
        
        
	@PostMapping
	public ResponseEntity<ChamadoDto> cadastrar(@RequestBody ChamadoForm form){
		Chamado chamado= form.converter(usuarioRepository);
		repository.save(chamado);
		return new ResponseEntity<>(new ChamadoDto(chamado),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ChamadoDto> atualizar(@PathVariable Long id, @RequestBody ChamadoForm form){
	
		Chamado chamado= form.atualiza(id, repository, usuarioRepository);
		
		return new ResponseEntity<>(new ChamadoDto(chamado),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id){
	
		 repository.deleteById(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}	
}
