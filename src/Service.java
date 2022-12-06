import java.util.*;

public class Service {
    // Một danh sách sinh viên
    List<Student> studentList = new ArrayList<>(); // 5 sinh vien nam trong list

    Scanner sc = new Scanner(System.in);
    public void addStudent() {
        System.out.print("Nhập số sinh viên bạn muốn thêm: ");
        // 5 ==> n = 5
        int n = sc.nextInt();
        sc.nextLine();
        Student s = new Student();
        String id, name, address;
        int age;
        double gpa;
        for (int i = 0; i < n; i++) {
            while(true) {
                try {
                    System.out.println("Nhập ID sinh viên " + (i+1));
                    id = sc.nextLine();
                    // id = 4, student list hiên có 5 người
                    s.setId(id, studentList);
                    break;
                } catch (ValidateException e) {
                    System.err.println(e.getMessage());
                }
            }
            while(true) {
                try {
                    System.out.println("Nhập tên sinh viên " + (i+1));
                    name = sc.nextLine();
                    s.setName(name);
                    break;
                } catch (ValidateException e) {
                    System.err.println(e.getMessage());
                }
            }
            while(true) {
                try {
                    System.out.println("Nhập tuổi sinh viên " + (i+1));
                    age = sc.nextInt();
                    s.setAge(age);
                    break;
                } catch (ValidateException e) {
                    System.err.println(e.getMessage());
                }
            }
            sc.nextLine();
            System.out.println("Nhập địa chỉ sinh viên " + (i+1));
            address = sc.nextLine();
            while(true) {
                try {
                    System.out.println("Nhập điểm sinh viên " + (i+1));
                    gpa = sc.nextDouble();
                    s.setGpa(gpa);
                    break;
                } catch (ValidateException e) {
                    System.err.println(e.getMessage());
                }
            }
            sc.nextLine();
            Student student = new Student(id,name,age,address,gpa);
            studentList.add(student);
        }
    }
    public void showStudent() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i+1) + ": " + studentList.get(i).toString());
        }
    }

    public void removeStudentByID() {
        System.out.print("Nhap ID sinh vien ban muon xoa: ");
        String id = sc.nextLine();
        // Nhap id ban muon xóa
        // ID 2
        boolean check = false;
        for(int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId().equals(id)) {
                Student s = studentList.remove(i);
                System.out.println("Xoa thanh cong sinh vien tai vi tri: " + i);
                System.out.println("Thong tin sinh vien bi xoa: " + s.toString());
                check = true;
            }
        }
        if(!check) {
            // !check sẽ tương đương với check == false
            System.out.println("Khong tim thay sinh vien de xoa");
        }
    }

    public void sortStudentByName() {
        System.out.println("Sắp xếp sinh viên theo thứ tự A -> Z");
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student sv1, Student sv2) {
                String fullName1 = sv1.getName();
                String fullName2 = sv2.getName();
                String lastName1 = fullName1.substring(fullName1.lastIndexOf(" ") + 1);
                String lastName2 = fullName2.substring(fullName2.lastIndexOf(" ") + 1);
                int compareName = lastName1.compareTo(lastName2);
                System.out.println("fullName 1: " + fullName1 + " " + "fullName 2: " + lastName2);
                System.out.println(compareName);
                if(compareName == 0) {
                    String firstName1 = fullName1.substring(0, fullName1.indexOf(" "));
                    String firstName2 = fullName2.substring(0, fullName2.indexOf(" "));
                    compareName = firstName1.compareTo(firstName2);
                    if(compareName >= 0) {
                        return  1;
                    }
                    return  -1;

                } else if(compareName > 1) {
                    System.out.println("Vao day 1");
                    return 1;
                } else {
                    System.out.println("Vao day -1");
                    return -1;
                }
            }
        });
    }
    public void sortStudentByGpa() {
        System.out.println("Sắp xếp sinh viên theo điểm tăng dần");
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student sv1, Student sv2) {
                // Nếu muốn sắp xếp điểm từ cao tới thấp thì đổi sv1.getGpa() > sv2.getGpa()
                if (sv1.getGpa() < sv2.getGpa()) {
                    return -1;
                } else {
                    if (sv1.getGpa() == sv2.getGpa()) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });
    }

    public void updateStudentByID() {
        System.out.print("Nhập ID sinh viên mà bạn muốn cập nhập : ");
        String name, address;
        double gpa;
        int age;
        String id = sc.nextLine();
        boolean check = false;
        for(int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId().equals(id)) {
                Student s = studentList.get(i);
                while(true) {
                    try {
                        System.out.println("Nhập tên sinh viên với ID là: " + id);
                        name = sc.nextLine();
                        s.setName(name);
                        break;
                    } catch (ValidateException e) {
                        System.err.println(e.getMessage());
                    }
                }
                while(true) {
                    try {
                        System.out.println("Nhập tuổi sinh viên với ID là: " + id);
                        age = sc.nextInt();
                        s.setAge(age);
                        break;
                    } catch (ValidateException e) {
                        System.err.println(e.getMessage());
                    }
                }
                sc.nextLine();
                System.out.println("Nhập địa chỉ sinh viên với ID là:  " + id);
                address = sc.nextLine();
                s.setAddress(address);
                while(true) {
                    try {
                        System.out.println("Nhập điểm sinh viên với ID là: " + id);
                        gpa = sc.nextDouble();
                        s.setGpa(gpa);
                        break;
                    } catch (ValidateException e) {
                        System.err.println(e.getMessage());
                    }
                }
                check = true;
                sc.nextLine();
            }
        }
        if(!check) {
            // !check sẽ tương đương với check == false
            System.err.println("Không tìm thấy sinh viên bạn muốn cập nhập");
        }
    }
}
