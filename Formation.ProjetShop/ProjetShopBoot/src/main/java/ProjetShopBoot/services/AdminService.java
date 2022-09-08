package ProjetShopBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjetShopBoot.entities.Admin;
import ProjetShopBoot.exceptions.AdminException;
import ProjetShopBoot.repositories.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminrepo;

	public Admin create(Admin admin) {
		if (admin.getUsername() == null & admin.getPassword().isEmpty()) {
			throw new AdminException();
		}
		return adminrepo.save(admin);
	}
	
	public Admin create(String username,String password) {
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		return create(admin);
	}
	
	public Admin update(Admin admin) {
		admin.setUsername(admin.getUsername());
		admin.setPassword(admin.getPassword());
		return adminrepo.save(admin);
	}
	public Admin getById(Long id) {
		Optional<Admin> opt = adminrepo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		throw new AdminException();
	}
	
	public List<Admin> getByUsername(String Username) {
		return adminrepo.findByUsername(Username);	
	}
	public List<Admin> getArticleById(Long id) {
		return adminrepo.findArticleById(id);
	}	

	public List<Admin> getAll() {
		return adminrepo.findAll();
	}
	
	public void delete(Admin admin) {
		adminrepo.delete(admin);
	}

	public void deleteById(Long id) {
		delete(getById(id));
	}
	
	
}
