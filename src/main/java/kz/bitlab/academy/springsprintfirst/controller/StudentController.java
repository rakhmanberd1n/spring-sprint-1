package kz.bitlab.academy.springsprintfirst.controller;


import kz.bitlab.academy.springsprintfirst.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @GetMapping("/addStudent")
    public String addStudentPage(){
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String createStudent(@RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("exam") int exam){
        StudentService.create(name, surname, exam);
        return "redirect:/";
        //return StudentService.create(name,surname,exam);

    }


    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("students", StudentService.findAll());
        return "index";
    }

}
