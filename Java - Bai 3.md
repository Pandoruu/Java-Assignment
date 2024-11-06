# Buổi 3: Mọi thứ đều là đối tượng
### 1. Tính đóng gói (Encapsulation)
*Tính đóng gói trong Java là một đặc tính quan trọng trong lập trình hướng đối tượng, giúp bảo vệ dữ liệu và kiểm soát quyền truy cập vào dữ liệu của một đối tượng.*

##### a. Cách đóng gói dữ liệu trong Java
- Khai báo các biến của đối tượng là `private` để giới hạn quyền truy cập từ các class khác.
- Sử dụng các phương thức `public` **Getter** và **Setter** để truy cập từ bên ngoài. Cài đặt cho class ngoài các phương thức **Getter** hoặc **Getter** hoặc cả 2 tùy vào quyền hạn.
```java
public class Book {
    //thuộc tính private để bảo vệ dữ liệu
    private String title, author, type, publicDate;

    //Constructor
    public Book(String title, String author, String type, String publicDate){
        this.title = title.trim();
        this.author = author.trim();
        this.type = type.trim();
        this.publicDate = publicDate.trim();
    }

    //Getter
    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getType(){ return type; }
    public String getPublicDate(){ return publicDate; }

    //Setter
    public void setTitle(String title){ this.title = title; }
    public void setAuthor(String author){ this.author = author; }
    public void setType(String type){ this.type = type; }
    public void setPublicDate(String pLD){ this.publicDate = pLD; }
}
```
##### b. Lợi ích của tính đóng gói
- **Bảo mật:** Bảo vệ dữ liệu nhạy cảm bên trong lớp.
- **Kiểm soát:** Kiểm soát cách dữ liệu được truy cập và sửa đổi.
- **Tính linh hoạt:** Cho phép thay đổi cấu trúc dữ liệu mà không ảnh hưởng đến mã bên ngoài.
- **Dễ bảo trì:** Dễ dàng sửa đổi, kiểm tra hoặc giới hạn quyền truy cập mà không ảnh hưởng đến các thành phần khác của chương trình.

*=> Áp dụng tính đóng gói thông minh giúp kiểm soát truy cập và tạo giao diện rõ ràng, đó là yếu tố cần thiết để xây dựng các ứng dụng Java chất lượng cao.*
### 2. Tính kế thừa (Inheritance)
*Tính kế thừa (Inheritance) trong Java là một đặc tính của lập trình hướng đối tượng, cho phép một lớp (class) có thể kế thừa các thuộc tính và phương thức từ một lớp khác. Điều này giúp tái sử dụng mã nguồn, giảm thiểu việc lặp lại mã, và tạo ra mối quan hệ phân cấp giữa các lớp.*
##### 2.1 Cách sử dụng tính kế thừa trong Java
- Trong Java, để sử dụng tính kế thừa, bạn sử dụng từ khóa `extends`. Lớp con (subclass) sẽ kế thừa từ lớp cha (superclass)
- Lớp con có thể sử dụng tất cả các thuộc tính và phương thức `public` hoặc `protected` của lớp cha. Ngoài ra, lớp con cũng có thể mở rộng hoặc ghi đè các phương thức của lớp cha.
```java
// Lớp cha
public class Animal {
    // Thuộc tính chung cho các loại động vật
    protected String ten;

    // Constructor
    public Animal(String ten) {
        this.ten = ten;
    }

    // Phương thức chung
    public void an() {
        System.out.println(ten + " đang ăn.");
    }

    public void ngu() {
        System.out.println(ten + " đang ngủ.");
    }
}
// Lớp con kế thừa từ lớp Animal
public class Dog extends Animal {
    
    // Constructor của lớp Dog
    public Dog(String ten) {
        super(ten); // Gọi constructor của lớp cha
    }

    // Phương thức đặc trưng của lớp Dog
    public void sua() {
        System.out.println(ten + " đang sủa.");
    }

    // Ghi đè phương thức an của lớp cha
    @Override
    public void an() {
        System.out.println(ten + " đang gặm xương.");
    }
}
```
- **Contrucstor trong kế thừa:** Từ khóa `super`được dùng trong constructor của lớp con để gọi constructor của lớp cha. Nếu không gọi `super()`, Java sẽ tự động gọi constructor không tham số của lớp cha.
##### 2.2 Đặc điểm của tính kế thừa
- **Tái sử dụng mã nguồn:** Lớp con có thể tái sử dụng các thuộc tính và phương thức từ lớp cha.
- **Tạo mối quan hệ phân cấp:** Giúp tổ chức mã nguồn theo dạng cây phân cấp, dễ hiểu và dễ quản lý.
- **Hỗ trợ tính đa hình:** Cho phép xử lý các đối tượng thuộc lớp con như là các đối tượng của lớp cha.
- **Tính mở rộng:** Lớp con có thể mở rộng hoặc ghi đè các phương thức của lớp cha để phù hợp với yêu cầu riêng.
- **Từ khóa final và Kế Thừa**: Từ khóa final có thể dùng để ngăn chặn kế thừa. Khi một lớp được khai báo là final, lớp đó không thể bị kế thừa bởi bất kỳ lớp nào khác. Phương thức final trong lớp cha cũng không thể bị ghi đè bởi lớp con.
```java
final class Animal {
    // ...
}

class Dog extends Animal { // Sẽ gây lỗi vì Animal là final
// }
```

##### 2.3 Variable Hiding (Ẩn Biến)
- Khi lớp con khai báo một biến trùng tên với biến của lớp cha, biến của lớp cha sẽ bị "ẩn" (variable hiding).
- Biến của lớp cha và lớp con trùng tên sẽ là các biến riêng biệt, được xác định theo kiểu của đối tượng.
```java
class Animal {
    public String name = "Animal";
}

class Dog extends Animal {
    public String name = "Dog";
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        System.out.println(a.name); // a.name truy cập vào name trong Animal
        
        Dog d = new Dog();
        System.out.println(d.name); // a.name truy cập vào name trong Dog
    }
}
```
##### 2.4 Ghi Đè Phương Thức (Method Overriding)
- Method Overriding là khi lớp con định nghĩa lại một phương thức của lớp cha với cùng tên, cùng tham số, và cùng kiểu trả về.
- Phương thức của lớp con sẽ được sử dụng thay thế khi gọi trên đối tượng của lớp con.
- Từ khóa `@Override` thường được dùng để chú thích phương thức ghi đè, giúp tăng tính rõ ràng và dễ bảo trì.
```java
class Animal {
    public void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```
##### 2.5 Đa kế thừa (Multiple Inheritance)
Java không hỗ trợ đa kế thừa với các lớp do có thể gây ra Diamond Problem (vấn đề kim cương), tức là khi một lớp có thể thừa hưởng hai bản sao của cùng một phương thức từ hai lớp cha khác nhau, gây xung đột.

Interface và Đa Kế Thừa Giải Quyết Diamond Problem
- Java cho phép đa kế thừa qua interface, cho phép một lớp có thể implement nhiều interface.
- Nếu các interface có phương thức trùng tên, lớp con phải override lại phương thức này để tránh lỗi.
```java
interface Walkable {
    void move();
}

interface Runnable {
    void move();
}

class Animal implements Walkable, Runnable {
    @Override
    public void move() {
        System.out.println("Animal is moving");
    }
}
```
Trong ví dụ này, `Animal` implement cả `Walkable` và `Runnable`, nhưng chỉ cần định nghĩa `move()` một lần.
### 3. Upcasting và Downcasting
##### 3.1 Upcasting
**Upcasting** là quá trình chuyển đổi một đối tượng của lớp con thành một đối tượng của lớp cha. Việc này có thể thực hiện một cách ngầm định (implicit casting) mà không cần sử dụng toán tử ép kiểu, vì lớp con luôn là một kiểu của lớp cha.

Đặc điểm của Upcasting:
- Dễ thực hiện: Upcasting được thực hiện một cách ngầm định.
- Hạn chế quyền truy cập: Sau khi upcast, bạn chỉ có thể truy cập các phương thức và thuộc tính được định nghĩa trong lớp cha.
- Lợi ích trong tính đa hình: Upcasting cho phép truyền đối tượng lớp con vào phương thức chấp nhận tham số là lớp cha.
```java
class Animal {
    public void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog barks");
    }

    public void fetch() {
        System.out.println("Dog fetches a ball");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Upcasting Dog thành Animal
        animal.sound(); // In ra "Dog barks" do tính đa hình
        // animal.fetch(); // Lỗi: không thể gọi fetch vì animal là kiểu Animal
    }
}
```
Ở ví dụ trên:
- Biến `animal` có kiểu `Animal` nhưng tham chiếu đến đối tượng `Dog`.
- Khi gọi `animal.sound()`, phương thức `sound()` của `Dog` sẽ được gọi thay vì của `Animal` nhờ vào tính đa hình.
- Tuy nhiên, bạn không thể gọi `animal.fetch()` vì `fetch()` không tồn tại trong lớp `Animal`.
- ##### 3.2 Downcasting
**Downcasting** là quá trình chuyển đổi ngược lại từ một đối tượng của lớp cha thành đối tượng của lớp con. Khác với upcasting, downcasting yêu cầu phải thực hiện ép kiểu tường minh vì có thể gây lỗi trong thời gian chạy nếu đối tượng không thuộc lớp con cụ thể.

Đặc điểm của Downcasting:
- Phải ép kiểu tường minh: Cần sử dụng toán tử ép kiểu `(TênLớpCon)`.
- Nguy cơ lỗi: Nếu đối tượng thực sự không phải là đối tượng của lớp con cụ thể, sẽ xảy ra lỗi `ClassCastException`.
- Cần kiểm tra trước khi ép kiểu: Sử dụng toán tử `instanceof` để kiểm tra kiểu của đối tượng trước khi thực hiện ép kiểu.
```java
public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog(); // Upcasting Dog thành Animal
        animal.sound(); // In ra "Dog barks"

        // Downcasting animal về Dog
        if (animal instanceof Dog) { // Kiểm tra kiểu đối tượng, đảm bảo rằng animal thực sự là đối tượng của Dog trước khi ép kiểu.
            Dog dog = (Dog) animal; // Ép kiểu tường minh về Dog
            dog.fetch(); // In ra "Dog fetches a ball"
        }
    }
}
```
##### 3.3 Khi nào nên sử dụng Upcasting và Downcasting?
- **Upcasting:** Thường dùng khi bạn muốn xử lý đối tượng một cách tổng quát, dựa trên lớp cha, và không cần các phương thức đặc trưng của lớp con. Ví dụ, dùng để áp dụng tính đa hình và truyền đối tượng con vào phương thức của lớp cha.

- **Downcasting:** Dùng khi bạn cần truy cập đến các phương thức hoặc thuộc tính cụ thể của lớp con mà lớp cha không có. Hãy luôn kiểm tra kiểu với instanceof trước khi downcast để tránh lỗi thời gian chạy.
### 4. Tính đa hình (Polymorphism)
Tính đa hình (Polymorphism) là một trong bốn tính chất cơ bản của lập trình hướng đối tượng, bên cạnh tính đóng gói, tính kế thừa, và tính trừu tượng. Đa hình cho phép một đối tượng có thể biểu hiện dưới nhiều hình thức khác nhau, hoặc nhiều lớp có thể có cùng tên phương thức nhưng thực thi theo cách riêng của chúng.

##### 4.1 Đặc Điểm Của Tính Đa Hình
Tính đa hình giúp các phương thức hoặc hành vi của đối tượng được xử lý khác nhau tùy thuộc vào kiểu của đối tượng đang thao tác. Có hai loại đa hình chính:

- Đa hình lúc biên dịch (Compile-time Polymorphism): Được thực hiện thông qua method overloading (nạp chồng phương thức).
- Đa hình lúc chạy (Runtime Polymorphism): Được thực hiện thông qua method overriding (ghi đè phương thức).
##### 4.2 Method Overloading (Đa Hình Lúc Biên Dịch)
Method Overloading là quá trình định nghĩa nhiều phương thức trong cùng một lớp với cùng tên nhưng khác nhau về số lượng hoặc kiểu tham số. Java sẽ chọn phương thức nào được gọi dựa trên danh sách tham số truyền vào khi biên dịch.
```java
class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        MathUtils math = new MathUtils();
        System.out.println(math.add(5, 10));       // Gọi add(int, int)
        System.out.println(math.add(5.5, 10.3));   // Gọi add(double, double)
        System.out.println(math.add(5, 10, 15));   // Gọi add(int, int, int)
    }
}
```
##### 4.3 Method Overriding (Đa Hình Lúc Chạy)
Method Overriding xảy ra khi lớp con định nghĩa lại một phương thức của lớp cha với cùng tên, cùng tham số, và cùng kiểu trả về. Điều này cho phép lớp con có thể cung cấp cách triển khai khác cho phương thức của lớp cha.
```java
class Animal {
    public void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // Upcasting Dog thành Animal
        Animal myCat = new Cat(); // Upcasting Cat thành Animal

        myDog.sound(); // Gọi sound() của Dog: "Dog barks"
        myCat.sound(); // Gọi sound() của Cat: "Cat meows"
    }
}
```
Trong ví dụ trên:

- Phương thức `sound()` được định nghĩa trong lớp `Animal` và được ghi đè trong các lớp con là `Dog` và `Cat`.
- Khi gọi `myDog.sound()` và `myCat.sound()`, phương thức `sound()` của lớp `Dog` và `Cat` sẽ được gọi, thay vì phương thức của `Animal`, thể hiện đa hình lúc chạy.
##### 4.4 Tính Đa Hình và Lợi Ích
- Tăng tính linh hoạt: Các đối tượng thuộc các lớp khác nhau có thể được xử lý thông qua cùng một giao diện, làm cho mã dễ mở rộng và bảo trì.
- Giảm phụ thuộc: Các lớp có thể thay đổi hoặc mở rộng mà không ảnh hưởng đến mã đã có, miễn là các phương thức vẫn tuân theo giao diện chung.
- Hỗ trợ tính mở rộng: Các lớp con có thể tùy biến hành vi bằng cách ghi đè phương thức lớp cha mà không thay đổi mã nguồn của lớp cha.

| Đặc điểm           | Method Overloading                                  | Method Overriding                                            |
| ------------------ | --------------------------------------------------- | ------------------------------------------------------------ |
| Thời điểm thực thi | Lúc biên dịch                                       | Lúc chạy                                                     |
| Mục đích           | Cho phép phương thức cùng tên với tham số khác nhau | Tùy biến hành vi của lớp con đối với phương thức của lớp cha |
| Yêu cầu về lớp     | Trong cùng 1 lớp                                    | Lớp cha và lớp con                                           |
| Kiểu tham số       | Phải khác nhau                                      | Phải giống nhau                                              |