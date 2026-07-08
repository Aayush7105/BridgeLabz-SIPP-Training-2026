import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeAttendanceRanking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append(" ");
        }
        String input = sb.toString();
        sc.close();

        List<Integer> employeeIds = new ArrayList<>();
        List<Integer> attendance = new ArrayList<>();
        int k = 0;

        if (input.contains("[")) {
            Pattern p = Pattern.compile("\\[([^\\]]*)\\]");
            Matcher m = p.matcher(input);
            if (m.find()) {
                String[] tokens = m.group(1).split("[,\\s]+");
                for (String t : tokens) {
                    t = t.trim();
                    if (!t.isEmpty()) {
                        employeeIds.add(Integer.parseInt(t));
                    }
                }
            }
            Pattern kPattern = Pattern.compile("K\\s*=\\s*(\\d+)", Pattern.CASE_INSENSITIVE);
            Matcher kMatcher = kPattern.matcher(input);
            if (kMatcher.find()) {
                k = Integer.parseInt(kMatcher.group(1));
            }
            if (m.find()) {
                String[] tokens = m.group(1).split("[,\\s]+");
                for (String t : tokens) {
                    t = t.trim();
                    if (!t.isEmpty()) {
                        attendance.add(Integer.parseInt(t));
                    }
                }
            }
        } else {
            Pattern numPattern = Pattern.compile("-?\\d+");
            Matcher numMatcher = numPattern.matcher(input);
            List<Integer> allNums = new ArrayList<>();
            while (numMatcher.find()) {
                allNums.add(Integer.parseInt(numMatcher.group()));
            }
            if (!allNums.isEmpty()) {
                int n = allNums.get(0);
                if (allNums.size() >= 2 * n + 2) {
                    for (int i = 1; i <= n; i++) {
                        employeeIds.add(allNums.get(i));
                    }
                    for (int i = n + 1; i <= 2 * n; i++) {
                        attendance.add(allNums.get(i));
                    }
                    k = allNums.get(2 * n + 1);
                }
            }
        }

        if (employeeIds.isEmpty() || attendance.isEmpty() || k <= 0) {
            return;
        }

        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < employeeIds.size() && i < attendance.size(); i++) {
            list.add(new Employee(employeeIds.get(i), attendance.get(i)));
        }

        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e2.attendance != e1.attendance) {
                    return Integer.compare(e2.attendance, e1.attendance);
                }
                return Integer.compare(e1.id, e2.id);
            }
        });

        System.out.print("[");
        for (int i = 0; i < k && i < list.size(); i++) {
            System.out.print(list.get(i).id);
            if (i < k - 1 && i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

class Employee {
    int id;
    int attendance;

    Employee(int id, int attendance) {
        this.id = id;
        this.attendance = attendance;
    }
}
