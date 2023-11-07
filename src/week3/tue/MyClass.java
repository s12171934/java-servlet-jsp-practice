package week3.tue;

public class MyClass {
    //RemoteControl rc = new SmartTelevision();
    MyClass(RemoteControl rc){
       // this.rc = rc;
    }
    RemoteControl rc = new SmartTelevision();
    MyClass myClass = new MyClass(rc);
    MyClass myClass2 = new MyClass(new SmartTelevision());
}
