package employee.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Example JPA entity.
 * <p>
 * To use it, get access to a JPA EntityManager via injection.
 * <p>
 * {@code
 *
 * @Inject EntityManager em;
 * <p>
 * public void doSomething() {
 * MyEntity entity1 = new MyEntity();
 * entity1.setField("field-1");
 * em.persist(entity1);
 * <p>
 * List<MyEntity> entities = em.createQuery("from MyEntity", MyEntity.class).getResultList();
 * }
 * }
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "First name", nullable = false)
    private String firstName;

    @Column(name = "Last name", nullable = false)
    private String lastName;

    @Column(name = "Email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "Department", nullable = false)
    private EmployeeDepartment employeeDepartment;

    @Column(name = "Date of birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "Date of employment", nullable = false)
    private LocalDate dateOfEmployment;

    @Column(name = "Salary", nullable = false)
    private Integer salary;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private EmployeeStatus employeeStatus = EmployeeStatus.ACTIVE;

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeDepartment getEmployeeDepartment() {
        return employeeDepartment;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public Integer getSalary() {
        return salary;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public boolean isActive() {
        return this.employeeStatus == EmployeeStatus.ACTIVE;
    }

    public boolean isInactive() {
        return this.employeeStatus == EmployeeStatus.INACTIVE;
    }

    public void enable() {
        this.employeeStatus = EmployeeStatus.ACTIVE;
    }

    public void disable() {
        this.employeeStatus = EmployeeStatus.INACTIVE;
    }

    public Employee() {
        super();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private EmployeeDepartment employeeDepartment;
        private LocalDate dateOfBirth;
        private LocalDate dateOfEmployment;
        private Integer salary;

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder employeeDepartment(EmployeeDepartment employeeDepartment) {
            this.employeeDepartment = employeeDepartment;
            return this;
        }

        public Builder dateOfBirth(final LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder dateOfEmployment(final LocalDate dateOfEmployment) {
            this.dateOfEmployment = dateOfEmployment;
            return this;
        }

        public Builder salary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public Employee build() {
            final Employee employee = new Employee();
            employee.firstName = firstName;
            employee.lastName = lastName;
            employee.email = email;
            employee.employeeDepartment = employeeDepartment;
            employee.dateOfBirth = dateOfBirth;
            employee.dateOfEmployment = dateOfEmployment;
            employee.salary = salary;
            return employee;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", employeeDepartment=" + employeeDepartment +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfEmployment=" + dateOfEmployment +
                ", salary=" + salary +
                ", employeeStatus=" + employeeStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) &&
                employeeDepartment == employee.employeeDepartment &&
                Objects.equals(dateOfBirth, employee.dateOfBirth) &&
                Objects.equals(dateOfEmployment, employee.dateOfEmployment) &&
                Objects.equals(salary, employee.salary) &&
                employeeStatus == employee.employeeStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                firstName,
                lastName,
                email,
                employeeDepartment,
                dateOfBirth,
                dateOfEmployment,
                salary,
                employeeStatus);
    }
}
