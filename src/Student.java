import java.util.List;

public class Student {
    private String id;
    private String name;
    private int age;
    private String address;
    private double gpa;

    public Student() {

    }
    // id = 1, name = Tien, age = 20, address = Hue, gpa = 9
    public Student(String id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id, List<Student> studentList) throws ValidateException{
        // ID = 2
        // Kiểm tra ID không được rỗng
        if(id.equals("")) {
            // equals =
            throw new ValidateException("ID Không Được Rỗng");
        }
        // Kiểm tra ID có bị trùng nhau hay không
        for(int i = 0; i < studentList.size(); i++) {
            if(studentList.get(i).getId().equals(id)) {
                throw new ValidateException("Trung ID");
            }
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws ValidateException{
        // Kiểm tra name có bị rỗng không
        if(name.equals("")) {
            throw new ValidateException("Ten khong duoc rong");
        }
        // Chữ và Khoảng trắng
        // Nguyen Tran Tien
        // Nguyen Tran Tien2 ==> Nó k hợp lệ
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) >= 97 && name.charAt(i) <= 122 ||
                    name.charAt(i) >= 65 && name.charAt(i) <= 90 || name.charAt(i) == 32) {
            }
            else {
                throw new ValidateException("Ten phai nam trong bang chu cai");
            }
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws ValidateException{
        // -2 // 80  // 102
        if(age < 0 || age > 100) {
            throw new ValidateException("Tuoi phai tu 0 -> 100");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) throws ValidateException{
        // Khi ban nhap -1  // 9 // 12
        if(gpa < 0 || gpa > 10) {
            throw new ValidateException("Diem chi nhan tu 0 -> 10");
        }
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gpa=" + gpa +
                '}';
    }
}
