package mari.lookify.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mari.lookify.Models.Lookify;

@Repository
public interface LookifyRepository extends CrudRepository<Lookify, Long>{
    List<Lookify> findAll();
    List<Lookify> findByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
}
