import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Staff[] staff = new Staff[3];
        staff[0] = new Staff("A",111111111,"VT");
        staff[1] = new Staff("B",222222222,"VN");
        staff[2] = new Staff("C",333333333,"VP");
        while (true) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quản Lý Nhân Viên");
        System.out.println("1. Thêm Nhân Viên");
        System.out.println("2. Xóa Nhân Viên");
        System.out.println("3. Hiện Thị Nhân Viên");
        System.out.println("4. Sửa Nhân Viên");
        System.out.println("Enter a choice :");
        int choice = scanner.nextInt();

            switch (choice) {
                case 1 :
                    staff = addStaff(staff);
                    break;
                case 2 :
                    staff = deleteStaff(staff);
                    break;
                case 3 :
                    showStaff(staff);
                    break;
                case 4 :
                    staff = insertStaff(staff);
                    break;
                case 5:
                    System.exit(5);
                default:
            }
        }
    }
    public static Staff createStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên :");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại :");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ :");
        String address = scanner.nextLine();
        Staff staff1 = new Staff(name,phoneNumber,address);
        return staff1;
    }


    public static Staff[] addStaff(Staff[] staff) {
        Staff[] newStaff = new Staff[staff.length + 1];
        for (int i = 0; i < staff.length; i++) {
            newStaff[i] = staff[i];
        }
        newStaff[staff.length] = createStaff();

        return newStaff;
    }

    public static Staff[] deleteStaff(Staff[] staff) {
        Scanner scanner = new Scanner(System.in);
        Staff[] newStaff = new Staff[staff.length - 1];
        System.out.println("Nhập id muốn xóa :");
        int id = scanner.nextInt();

        for (int i = 0; i < staff.length; i++) {
            if (i < id - 1) {
                newStaff[i] = staff[i];
            }else if (i > id - 1) {
                newStaff[i - 1] = staff[i];
            }
        }
        return newStaff;

    }

    public static void showStaff(Staff[] staff) {
        for (Staff array:
             staff) {
            System.out.println(array);
        }
    }

    public static Staff[] insertStaff(Staff[] staff){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id muốn sửa :");
        int index = scanner.nextInt();
        for (int i = 0; i < staff.length; i++) {
            if (index == staff[i].getId()) {
                staff[i] = createStaff();
            }
        }
        return staff;
    }
}
