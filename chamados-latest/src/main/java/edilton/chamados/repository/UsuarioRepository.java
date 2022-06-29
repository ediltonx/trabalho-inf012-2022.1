package edilton.chamados.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edilton.chamados.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login); 
}
