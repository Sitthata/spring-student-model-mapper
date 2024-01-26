package sit.example.int204springapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.example.int204springapi.dto.OfficeDTO;
import sit.example.int204springapi.models.Employee;
import sit.example.int204springapi.models.Office;
import sit.example.int204springapi.repository.EmployeeRepository;
import sit.example.int204springapi.repository.OfficeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfficeService {
    private final OfficeRepository officeRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getById(Integer id) {
        return officeRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office not found")
        );
    }

    public String addNewOffice(Office office) {
         officeRepository.save(office);
         return "Office add successfully";
    }

    @Transactional
    public String removeOffice(Integer id) {
        Office office = officeRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office not found")
        );
        officeRepository.delete(office);
        return "Office remove successfully";
    }

    @Transactional
    public String updateOffice(Integer id, Office office) {
        Office office1 = officeRepository.findById(id).orElseThrow(
                () -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Office not found")
        );
        office1.setCity(office.getCity());
        office1.setPhone(office.getPhone());
        officeRepository.save(office1);
        return "Office update successfully";
    }

    public List<Employee> getEmployees(Integer id) {
        return employeeRepository.findByOfficeId(id);
    }
}
