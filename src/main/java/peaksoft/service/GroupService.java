package peaksoft.service;

import peaksoft.entities.Group;

import java.util.List;

public interface GroupService {
    void addGroup(Long courseId, Group group);
    List<Group> getAllGroup();
    Group  getGroupById(Long id);
    void updateGroup(Long id, Group group);
    void deleteGroup(Group group);
}
