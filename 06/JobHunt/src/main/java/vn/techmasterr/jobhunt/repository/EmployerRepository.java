package vn.techmasterr.jobhunt.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import vn.techmasterr.jobhunt.model.Employer;

@Repository
public class EmployerRepository {
  List<Employer> employerLists = new ArrayList<>();

  public List<Employer> getAll() {
    return employerLists;
  }

  public Optional<Employer> get(String id) {
    return employerLists.stream().filter(u -> u.getId().contains(id)).findFirst();
  }

  public void add(Employer employer) {
    String uuid = UUID.randomUUID().toString();
    employer.setId(uuid);
    employerLists.add(employer);
  }

  public void update(Employer employer) {
    get(employer.getId()).ifPresent(existemployee -> {
      existemployee.setName(employer.getName());
      existemployee.setWebsite(employer.getWebsite());
      existemployee.setEmail(employer.getEmail());
      existemployee.setAddress(employer.getAddress());
    });
  }

  public void deleteByID(String id) {
    get(id).ifPresent(existemployer -> employerLists.remove(existemployer));

  }

  public void delete(Employer employer) {
    deleteByID(employer.getId());
  }
}