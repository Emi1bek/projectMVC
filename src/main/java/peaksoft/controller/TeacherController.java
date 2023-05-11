package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.entities.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;
import peaksoft.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final GroupService groupService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, GroupService groupService, CourseService courseService) {
        this.teacherService = teacherService;
        this.groupService = groupService;
        this.courseService = courseService;
    }

//        @ModelAttribute("groupList")
//    public List<Group> getGroupList(){
//        return groupService.getAllGroup();
//    }
    @ModelAttribute("courseList")
    public List<Course> getCourseList() {
        return courseService.getAllCourse();
    }


    @GetMapping()
    private String getAllTeacher(Model model) {
        List<Teacher> teachers = teacherService.getAllTeacher();
        model.addAttribute("teachers", teachers);
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.addTeacher(teacher.getCourseId(), teacher);
        return "redirect:/teachers";

    }

    @GetMapping("/update/{id}")
    public String updateTeacher(@PathVariable("id") Long id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        model.addAttribute("updateTeacher", teacher);
        return "teacher/updateTeacher";
    }

    @PatchMapping("{id}")
    public String saveUpdateTeacher(@PathVariable("id") Long id, @ModelAttribute("course") Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return "redirect:/teachers";
    }

    @DeleteMapping("/delete")
    public String deleteTeacher(@RequestParam("id") Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teachers";
    }


}
