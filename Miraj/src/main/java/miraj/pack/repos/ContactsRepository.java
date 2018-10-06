package miraj.pack.repos;

import miraj.pack.domain.Contacts;
import org.springframework.data.repository.CrudRepository;

public interface ContactsRepository extends CrudRepository<Contacts,Integer> {
}
