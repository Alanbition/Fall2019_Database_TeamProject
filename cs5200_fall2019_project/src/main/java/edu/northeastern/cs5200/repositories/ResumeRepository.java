package edu.northeastern.cs5200.repositories;
import org.springframework.data.repository.CrudRepository;
import edu.northeastern.cs5200.models.Resume;

public interface ResumeRepository extends CrudRepository<Resume, Integer>{

}