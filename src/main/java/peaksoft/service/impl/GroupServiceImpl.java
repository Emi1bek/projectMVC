package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.dao.GroupDao;
import peaksoft.entities.Group;
import peaksoft.service.GroupService;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService {

    private final GroupDao groupDao;
    @Autowired
    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public void addGroup(Long courseId, Group group) {
        groupDao.addGroup(courseId,group);
    }

    @Override
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }

    @Override
    public void updateGroup(Long id, Group group) {
        groupDao.updateGroup(id, group);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDao.deleteGroup(group);
    }
}
