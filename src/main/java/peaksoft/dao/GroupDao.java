package peaksoft.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.entities.Course;
import peaksoft.entities.Group;

import java.util.List;

public interface GroupDao {
    void addGroup(Long courseId, Group group);
    List<Group> getAllGroup();
    Group  getGroupById(Long id);
    void updateGroup(Long id, Group group);
    void deleteGroup(Group group);

}
