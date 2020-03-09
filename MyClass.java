public class MyClass {

  static String printString(String name) {
    return "name is " + name + "\n";
  }

  static void loop() {
    String[] arr = { "foo", "bar", "fizz", "buzz" };
    for (int i = 0; i < arr.length; i++) {
      System.out.print(printString(arr[i]));
    }
  }

  public static void main(String[] args) {

    class Person {
      private String name;

      public String getName() {
        return name;
      }

      public void setName(String newName) {
        this.name = newName;
      }
    }
    Person person = new Person();
    person.setName("Jirppa");
    System.out.print(person.getName());
  }
}
