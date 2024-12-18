package dz.minagri.stat.customer.repository;

import dz.minagri.stat.customer.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findById(Long id);

    List<Company> findAll();

    Company findOneById(Long id);
    
    Company getByCompanyName(String name);

    Company getBycompanyOfficialName(String officialname);

    List<Company> findByVat(String vat);

    void deleteById(Long id);

}
