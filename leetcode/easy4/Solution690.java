package interview.easy4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/27 0027.
 */
public class Solution690 {
    public  class  Employee{
        int id;
        int importance;
        List<Integer> subordinate;
        Employee(int _id, int _importance, List<Integer> _subordinate){
            id = _id;
            importance = _importance;
            subordinate = _subordinate;
        }
    }
    public  int findEmployee(List<Employee> employees, int id){
        int index = 0;
        while (index < employees.size()){
            if(employees.get(index).id == id){
                return  index;
            }else {
                index++;
            }
        }
        return  -1;
    }

    public  int getImportance(List<Employee> employees, int id){
        int targetIndex = findEmployee(employees, id);
        int sum  = employees.get(targetIndex).importance;
        List<Integer> subornates = employees.get(targetIndex).subordinate;
        if(subornates.size() == 0){
            return  employees.get(targetIndex).importance;
        }
        for(int i = 0; i < subornates.size(); i++){
            sum += getImportance(employees, subornates.get(i));
        }

        return  sum;
    }

    @Test
    public  void  test(){
        Employee employee1 = new Employee(1, 5, new ArrayList<Integer>());
        Employee employee2 = new Employee(2, 3, new ArrayList<Integer>());
        Employee employee3 = new Employee(3, 3, new ArrayList<Integer>());
        Employee employee4 = new Employee(4, 1, new ArrayList<>());

        employee1.subordinate.add(2);
        employee1.subordinate.add(3);
        employee2.subordinate.add(4);

        List<Employee> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);

        System.out.println(getImportance(list, 1));

    }
}
