package cn.edu.sxgkd.service;

import cn.edu.sxgkd.entity.Task;
import cn.edu.sxgkd.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements ITaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> selectAll() {
        return taskMapper.selectAll();
    }

    @Override
    public Task selectById(int id) {
        return taskMapper.selectById(id);
    }

    @Override
    public int insert(Task task) {
        return taskMapper.insert(task);
    }

    @Override
    public int update(Task task) {
        return taskMapper.update(task);
    }

    @Override
    public int delete(int id) {
        return taskMapper.delete(id);
    }

    @Override
    public List<Task> selectByTitleAndDesc(String title, String desc) {
            Map<String,String> map = new HashMap<>();
            map.put("title",title);
            map.put("description",desc);
            return taskMapper.selectByTitleAndDescriptionBlur(map);
    }
}
