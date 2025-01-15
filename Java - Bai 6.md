# BUỔI 6: INTERFACE VÀ TRỪU TƯỢNG
### Interface là gì? Abstract class là gì?
**Interface** 
- **Định nghĩa:** `Interface` (giao diện) là một tập hợp các phương thức trừu tượng (abstract methods) - chỉ có tên hàm mô tả hành vi của hàm mà không có thân hàm, và có thể có các thuộc tính tĩnh (các biến là static final).
- **Cách dùng:** Được dùng để định nghĩa một bộ khung hành vi (behavior) mà các lớp thực thi (implement) nó cần tuân theo.

```Java
public interface Son {
    void reportGrade();
}

public class Individual implements Son{
    private String name;
    private double grade;

    //constructor
    public Individual(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    //getter
    public String getName() {
        return name;
    }
    public double getGrade() {
        return grade;
    }

    //methods
    @Override
    public void reportGrade() {
        System.out.println(getName() + " được điểm: " + getGrade() + "!");
    }
}
public class Main {
    public static void main(String[] args) {
        Individual a = new Individual("Ngân", 9.5);
        a.reportGrade();
    }
}
```

**Abstract class**
- **Định nghĩa:** `Abstract class` (lớp trừu trượng) có bản chất là 1 class (chứa biến, phương thức,...) nhưng có thêm các abstract method.
- **Cách dùng:** KKhông thể tạo ra 1 đối tượng từ abstract class như mộtmột class thông thường. Ta có thể dùng các class khác để extends từ abstract class. Khi một class kế thừa một abstract class thì class đó phải implement tất cả các abstract methods của abstract class

```Java
public abstract class Student {
    abstract void study();
}

public class Individual extends Student {
    private String name;

    //constructor
    public Individual(String name) {
        this.name = name;
    }

    //getter
    public String getName() {
        return name;
    }

    //methods
    @Override
    public void study() {
        System.out.println(getName() + " đang học!");
    }
}

public class Main {
    public static void main(String[] args) {
        Individual a = new Individual("Ngân");
        a.study();
    }
}
```

**=>** Sử dụng **Interface** và **Abstract Class** là để đạt được tính trừu tượng trong lập trình hướng đối tượng.

### So sánh Interface và Abstract class

| Interface                                                                                                                                                                                          | Abstract class                                                                                                                                                        |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Chứa các abstract method  và biến default                                                                                                                                                          | Chứa các phương thức abstract và non-abstract                                                                                                                         |
| Interface hỗ trợ đa kế thừa                                                                                                                                                                        | Lớp trừu tượng không hỗ trợ đa kế thừa                                                                                                                                |
| Interface không thể có phương thức static, main hoặc constructor                                                                                                                                   | Lớp trừu tượng có thể có phương thức static, phương thức main và constructor                                                                                          |
| Sử dụng Interface khi bạn muốn tạo dựng một bộ khung chuẩn gồm các chức năng (method/ function) thể hiện hành vi của một nhóm đối. Các class phải `implements` tất cả chức năng đã được định nghĩa | Sử dụng Abstract class khi chúng ta chỉ có thể hoàn thành một vài chức năng (method/ function) chuẩn ban đầu, một vài chức năng còn lại do các lớp extends định nghĩa |

### Tính trừu tượng
Trong lập trình, tính trừu tượng được sử dụng để định nghĩa một hệ thống mà các chi tiết phức tạp được ẩn đi, chỉ cung cấp các hành vi cần thiết thông qua các lớp trừu tượng (`abstract classes`) hoặc giao diện (`interfaces`).

**1. Sử dụng Abstract Class:**
- Dùng để định nghĩa các phương thức mà lớp con phải triển khai (implement).
- Có thể chứa các phương thức đã được định nghĩa sẵn (concrete methods).

**2. Sử dụng Interface:**

- Định nghĩa hoàn toàn các hành vi (methods) mà các lớp triển khai phải tuân theo.
- Interface có thể chứa default methods (phương thức mặc định) hoặc static methods.

### Enum và cách sử dụng

##### 1. Enum là gì?
- **Enumeration** (liệt kê) là một kiểu dữ liệu đặc biệt trong Java được sử dụng để đại diện cho một tập hợp các hằng số (constants) được định nghĩa trước
- **Enum** tự động kế thừa từ `java.lang.Enum`, không thể kế thừa từ lớp khác.
- Có thể sử dụng enum trong các cấu trúc điều kiện như `switchh` và `if`

##### 2.Cách sử dụng
- Khai báo:
```Java
enum EnumName {
    CONSTANT1, CONSTANT2, CONSTANT3
}
```
- Cách dùng:

```Java
enum XepLoai {
    Gioi,
    Kha,
    TrungBinh,
    Kem
}
public class Main {
    public static void main(String[] args) {
        double grade=6.5;
        if(grade>=8.5) System.out.println(XepLoai.Gioi);
        else if(grade>=7.5) System.out.println(XepLoai.Kha);
        else if(grade>=5) System.out.println(XepLoai.TrungBinh);
        else System.out.println(XepLoai.Kem);
    }
}
```

- Dùng với phương thức để giúp gắn thêm hành vi (behavior) cho các giá trị của enum, làm tăng tính ứng dụng thực tế. VD:

```Java
package demo2;

public enum Tier {
    Gioi,
    Kha,
    TB,
    Kem;

    public static Tier getTier(double grade){
        if(grade>=8.5) return Gioi;
        if(grade>=7.5) return Kha;
        if(grade>=5) return TB;
        return Kem;
    }
}

public class Individual {
    private String name;
    private double grade;

    //constructor
    public Individual(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    //getter
    public String getName() {
        return name;
    }
    public double getGrade() {
        return grade;
    }
    public void getTier(){
        System.out.println(getName() + " được xếp loại: " + Tier.getTier(getGrade()));
    }
}

public class Main {
    public static void main(String[] args) {
        Individual a = new Individual("Ngân", 9.5);
        a.getTier();
    }
}

```