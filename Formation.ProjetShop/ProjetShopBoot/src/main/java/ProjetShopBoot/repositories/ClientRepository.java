package ProjetShopBoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetShopBoot.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByNom(String nom);

	List<Client> findByPrenom(String prenom);

	List<Client> findByPrenomOrNom(String prenom, String nom);

	List<Client> findByPrenomContainingOrNomContaining(String prenom, String nom);

	Optional<Client> findByUsername(String username);

	Optional<Client> findById(@Param("id") Long id);

	@Query("select c from Client c left join fetch c.commandes where c.id=:id")
	Optional<Client> findByKeyWithCommandes(@Param("id") Long id);

}
