package com.leetcode.myCode;

import java.util.List;

public class L690_EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
    //用搜索的方法获取Employee
    private int res;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null) return res;
        DFS(employees, getEmployee(employees, id));
        return res;
    }
    public void DFS(List<Employee> employees, Employee e) {
        if (e != null) {
            res += e.importance;
            for (Integer id : e.subordinates) {
                DFS(employees, getEmployee(employees, id));
            }
        }
    }
    public Employee getEmployee(List<Employee> employees, int id) {
        Employee res = null;
        for (Employee e : employees) {
            if (e.id == id) {
                res = e;
                break;
            }
        }
        return res;
    }

    //用map加速获取Employee
    Employee[] map = new Employee[2001];
    public int getImportance1(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map[e.id] = e;
        }
        return DFS(map[id]);
    }
    public int DFS(Employee e) {
        int res = 0;
        if (e != null) {
            res += e.importance;
            for (int id : e.subordinates) {
                res += DFS(map[id]);
            }
        }
        return res;
    }

    // 不使用返回值
//    private Employee[] map = new Employee[2001];
//    private int res;
    public int getImportance2(List<Employee> employees, int id) {
        for (Employee e : employees) {
            map[e.id] = e;
        }
        DFS1(map[id]);
        return res;
    }
    public void DFS1(Employee e) {
        if (e != null) {
            res += e.importance;
            for (int id : e.subordinates)
                DFS1(map[id]);
        }
    }
}
