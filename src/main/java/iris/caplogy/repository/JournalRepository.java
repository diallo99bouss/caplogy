package iris.caplogy.repository;

import iris.caplogy.entity.Journal;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepository extends CrudRepository<Journal, Long> {
}
