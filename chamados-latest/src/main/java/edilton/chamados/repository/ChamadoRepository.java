package edilton.chamados.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import edilton.chamados.model.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Long>{

	Page<Chamado> findById(Long id, Pageable pageable);  
        //Page<Chamado> findByName(String nomeUsuario, Pageable pageable);  

}
