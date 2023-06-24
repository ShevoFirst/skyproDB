package pro.sky.skyprodb.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.skyprodb.model.Employee;
import pro.sky.skyprodb.service.CrudEmloyeeDaoImpl;
import java.math.BigInteger;

@RestController
@RequestMapping("/employees")
@Tag(name = "Сотрудники", description = "CRUD операции и другие эндпоинты с сотрудниками")
public class EmployeesController {
    private final CrudEmloyeeDaoImpl crudDao;

    public EmployeesController(CrudEmloyeeDaoImpl crudDao) {
        this.crudDao = crudDao;
    }

    @PostMapping
    @Operation(
            summary = "Добавление сотрудника"
    )
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        crudDao.create(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "получение сотрудника"
    )
    public ResponseEntity getEmployee(@PathVariable BigInteger id){
        crudDao.readById(id);
        return ResponseEntity.ok(crudDao.readById(id));
    }

    @GetMapping("/young")
    @Operation(
            summary = "получение пять самых молодых сотрудников"
    )
    public ResponseEntity GetFiveYoungestEmployees(){

        return ResponseEntity.ok(crudDao.GetFiveYoungestEmployees());
    }
    @GetMapping("/all")
    @Operation(
            summary = "получение всех сотруников по странично"
    )
    public ResponseEntity GetAllEmployees(@RequestParam("page") Integer page,@RequestParam("size") Integer size){

        return ResponseEntity.ok(crudDao.getAllEmployees(page, size));
    }
    @GetMapping("/avg")
    @Operation(
            summary = "получение среднего возраста всех сотрудников"
    )
    public ResponseEntity getMediumAgeByEmployee(){
        return ResponseEntity.ok(crudDao.getMediumAgeByEmployee());
    }
    @GetMapping("/count")
    @Operation(
            summary = "получение количества сотрудников"
    )
    public ResponseEntity getCountOfEmployees(){
        return ResponseEntity.ok(crudDao.getCountOfEmployees());
    }


    @PutMapping("{id}")
    @Operation(
            summary = "редактирование сотрудника"
    )
    public ResponseEntity editEmpoyee(@RequestBody Employee employee){
        crudDao.update(employee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "удаление сотрудника"
    )
    public ResponseEntity deleteEmployee(@PathVariable BigInteger id){
        crudDao.deleteById(id);
        return ResponseEntity.ok(crudDao.readById(id));
    }
}
