package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Group;
import peaksoft.entities.Student;
import peaksoft.entities.Teacher;
import peaksoft.service.GroupService;
import peaksoft.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final GroupService groupService;

    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @ModelAttribute("groupList")
    public List<Group> getGroupList(){
        return groupService.getAllGroup();
    }

    @GetMapping()
    private String getAllStudent(Model model){
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students",students);
        return "student/students";
    }

    @GetMapping("/addStudent")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "student/addStudent";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.addStudent(student.getGroupId(),student);
        return "redirect:/students";

    }
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, Model  model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("updateStudent", student);
        return "student/updateStudent";
    }
    @PatchMapping("{id}")
    public String saveUpdateStudent(@PathVariable("id") Long id, @ModelAttribute("course")Student student){
        studentService.updateStudent(id,student);
        return "redirect:/students";
    }
    @DeleteMapping("/delete")
    public String deleteTeacher(@RequestParam("id") Long id){
        Student student = studentService.getStudentById(id);
        studentService.deleteStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/studentPage")
    public String studentPage(){

        return "student/studentPage";
    }
    @GetMapping("/studentCss")
    public String studentCss(){

        return "/style";
    }
}
