package ua.doc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.doc.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
