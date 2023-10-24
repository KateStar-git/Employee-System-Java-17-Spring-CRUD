package com.example.jsfcrud.controllers;
import com.example.jsfcrud.repositories.EmployeeRepository;
import com.example.jsfcrud.entities.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
public class EmployeeController {
  private final EmployeeRepository repository;

  @Autowired
  public EmployeeController(EmployeeRepository repository) {
    this.repository = repository;
  }

  @Autowired
  private MessageSource messageSource;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginPage() {
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String indexPage(ModelMap model, @RequestParam String userName, @RequestParam String password) {
////    if(userName.equals("kasia") && password.equals("1234")){
//
//      return "index";
//   // }
//   // model.put("errorMsg", "Please provide the correct user name and password");
//    return "login";
    return "index";
  }

  @GetMapping("/index")
  public String showEmployeeList(Model model) {

    model.addAttribute("employees", repository.findAllByOrderByLastNameAsc());
    return "index";
  }

  @GetMapping("/add")
  public String showNewEmployee(Employee employee) {
    return "add";
  }

  @PostMapping("/add")
  public String saveNewEmployee(@Valid Employee e, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "add";
    }
    repository.save(e);
    return "redirect:/index";
  }

  @GetMapping("/edit/{id}")
  public String showExistingEmployee(@PathVariable("id") long id, Model model) {
    Employee e = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employeeId:" + id));
    model.addAttribute("employee", e);
    model.addAttribute("title", "Edit Employee");
    return "update";
  }

  @PostMapping("/update/{id}")
  public String updateEmployee(@PathVariable("id") long id, @Valid Employee e, BindingResult result, Model model) {
    if (result.hasErrors()) {
      e.setEmployeeId(id);
      return "update";
    }
    e.setEmployeeId(id);
    repository.save(e);
    return "redirect:/index";
  }

  @GetMapping("/delete/{id}")
  public String deleteEmployee(@PathVariable("id") long id, Model model) {
    Employee e = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id:" + id));
    repository.delete(e);
    return "redirect:/index";
  }

}
