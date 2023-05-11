package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.Course;
import peaksoft.entities.Group;
import peaksoft.service.CourseService;
import peaksoft.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;


    public GroupController(GroupService groupService, CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }
    @ModelAttribute("courseList")
    public List<Course> getCourseList(){
        return courseService.getAllCourse();
    }

    @GetMapping()
    private String getAllGroup(Model model){
        List<Group> groups = groupService.getAllGroup();
        model.addAttribute("groups",groups);
        return "group/groups";
    }

    @GetMapping("/addGroup")
    public String addGroup(Model model){
        model.addAttribute("group", new Group());
        return "group/addGroup";
    }
    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("groups")Group group){
        groupService.addGroup(group.getCoursId(),group);
        return "redirect:/groups";

    }
    @GetMapping("/update/{id}")
    public String updateGroup(@PathVariable("id") Long id, Model  model){
        Group group = groupService.getGroupById(id);
        model.addAttribute("updateGroup", group);
        return "group/updateGroup";
    }
    @PatchMapping("{id}")
    public String saveUpdateGroup(@PathVariable("id") Long id, @ModelAttribute("group")Group group){
        groupService.updateGroup(id,group);
        return "redirect:/groups";
    }
    @DeleteMapping("/delete")
    public String deleteGroup(@RequestParam("id") Long id){
        Group group = groupService.getGroupById(id);
        groupService.deleteGroup(group);
        return "redirect:/groups";
    }

}
