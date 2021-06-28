package designPattern.behavior.itor.design.group;

import designPattern.behavior.itor.design.lang.Collection;
import designPattern.behavior.itor.design.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroupStructure implements Collection<Employee, Link> {
    private String groupId;
    private String groupName;

    private Map<String, Employee> employeeMap = new ConcurrentHashMap<>(); // 雇员列表
    private Map<String, List<Link>> listMap = new ConcurrentHashMap<>();   // 组织架构关系
    private Map<String, String> invertedMap = new ConcurrentHashMap<>();   // 方向关系链

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getuId(), employee);
    }

    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getuId());
    }

    @Override
    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        if (listMap.containsKey(key)) {
            return listMap.get(key).add(link);
        } else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            listMap.put(key, links);
            return true;
        }
    }

    @Override
    public boolean removeLink(String key) {
        return null != listMap.remove(key);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {

            Map<String, Integer> keyMap = new HashMap<>();
            int totalIdx = 0;
            private String fromId = groupId;
            private String toId = groupId;

            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {
                List<Link> links = listMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                // 同级扫描
                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = listMap.get(fromId);
                }

                // 上级扫描
                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = listMap.get(fromId);
                }

                // 获得节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;

                return employeeMap.get(link.getToId());
            }

            // 给每个层级定义宽度遍历进度
            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };
    }
}
