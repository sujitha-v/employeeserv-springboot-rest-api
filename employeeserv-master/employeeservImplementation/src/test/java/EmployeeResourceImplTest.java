import com.paypal.bfs.test.employeeserv.Repository.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.model.Address;
import com.paypal.bfs.test.employeeserv.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.Matchers.anyLong;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeResourceImplTest {

    @InjectMocks
    EmployeeResourceImpl employeeResourceImpl;

    @Mock
    EmployeeRepository employeeRepository;

    @Test
    public void getEmployeeTest() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Sujitha");
        employee.setLastName("Vemula");
        employee.setDob("**/**/****");
        employee.setAddress(new ArrayList<>());
        Mockito.when(employeeRepository.findById(anyLong())).thenReturn(Optional.of(employee));
        ResponseEntity<Employee> emp = employeeResourceImpl.employeeGetById(1L);
        Assert.assertEquals(Objects.requireNonNull(emp.getBody()).getFirstName(),"Sujitha");
    }

    @Test
    public void createEmployeeTest() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Sujitha");
        employee.setLastName("Vemula");
        employee.setDob("**/**/****");
        employee.setAddress(new ArrayList<>());
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Employee emp = employeeResourceImpl.create(employee);
        Assert.assertEquals(emp.getFirstName(),"Sujitha");
    }
}
