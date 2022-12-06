import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Service s = new Service();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("/****************************/");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Cập nhật thông tin sinh viên theo ID");
            System.out.println("3. Xóa sinh viên theo ID");
            System.out.println("4. Sắp xếp sinh viên theo tên");
            System.out.println("5. Sắp xếp sinh viên theo điểm từ thấp lên thấp");
            System.out.println("6. Hiển thị danh sách sinh viên");
            System.out.println("7. Kết thúc chương trình");
            System.out.println("/****************************/");
            System.out.println("Lua chon muc ban muon: ");
            int number = sc.nextInt();

            switch (number) {
                case 1:
                    s.addStudent();
                    break;
                case 2:
                    s.updateStudentByID();
                    break;
                case 3:
                    s.removeStudentByID();
                    break;
                case 4:
                    s.sortStudentByName();
                    break;
                case 5:
                    s.sortStudentByGpa();
                    break;
                case 6:
                    s.showStudent();
                    break;
                case 7:
                    System.out.println("Tụm bịt");
                    System.exit(0);
                default:
                    System.out.println("Chọn lại");
                    break;
            }
        }
    }
}