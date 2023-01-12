package com.ty.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.employeeapp.beans.Employee;
import com.ty.employeeapp.dto.EmployeeDto;
import com.ty.employeeapp.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/index")
	public ModelAndView getHomePage(ModelAndView modelAndView) {
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@GetMapping("/add-emp")
	public ModelAndView getAddEmploeePage(ModelAndView modelAndView) {
		modelAndView.setViewName("add-employee");
		return modelAndView;
	}
	@PostMapping("/employee")
	public String addEmployee(Employee employee,Model model) {
		EmployeeDto addEmployee=employeeService.addEmployee(employee);
		if (addEmployee != null) {
			model.addAttribute("msg", "Employee Added");
			return "redirect:/index";
		} else {
			return "redirect:/add-emp";
		}	
	}
	@GetMapping("/serach-emp-page")
	public ModelAndView getSearchEmpPage(ModelAndView modelAndView) {
		modelAndView.setViewName("search-employee");
		return modelAndView;
	}
	@GetMapping("/search-emp")
	public ModelAndView searchEmployee(@RequestParam("id") int id, Model model, ModelAndView modelAndView) {
		EmployeeDto employeeDto=employeeService.searchEmployee(id);
		if(employeeDto!=null)
			model.addAttribute("msg",employeeDto);
		else 
			model.addAttribute("msg","Employee Data not found fot Employee Number "+ id );
		modelAndView.setViewName("display-emp");
		
		return modelAndView;	
	}
	@GetMapping("/list-all")
	public ModelAndView listAllEmployees(ModelAndView modelAndView, Model model) {
		List<EmployeeDto> allEmps=employeeService.getAllEmployees();
		model.addAttribute("emps", allEmps);
		modelAndView.setViewName("displayall-emp");

		return modelAndView;
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView getEditEmployeePage(ModelAndView modelAndView,Model model, @PathVariable("id") int id) {
		EmployeeDto searchedEmp=employeeService.searchEmployee(id);
		if (searchedEmp==null) {
			model.addAttribute("msg", "Update Cannot be done because Data not found for Employee Id "+id);
			modelAndView.setViewName("display-emp");
		} else {
			model.addAttribute("emp", searchedEmp);
			modelAndView.setViewName("edit-emp");
		}
		return modelAndView;	
	}
	@PostMapping("/update-emp")
	public String updateTrain(Employee employee,ModelAndView modelAndView,@RequestParam("id")int id) {
		EmployeeDto employeeDto = employeeService.updateEmployee(id, employee);
		return "redirect:/list-all";
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("id") int id,Model model) {
		EmployeeDto deletedEmp=employeeService.deleteEmployee(id);
		if (deletedEmp==null) {
			model.addAttribute("msg","Deleted can't be done becaz data not found for the Employee Id "+ id);
			return "display-emp";
		} 
			return "forward:/list-all";
	}
	
	

}
