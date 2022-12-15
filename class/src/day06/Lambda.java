package day06;

import java.util.List;

public class Lambda {

  // pass a function through a function, only need to add the type
  public static void apply(Greetings greeting, String value){
    greeting.hello(value);
  }

  // only looks at the signature, doesnt look at the name, looks like greetings.java
  public static void toUpperCase(String str){
    System.out.printf(">>> %s = %s\n", str, str.toUpperCase());
  }

  public static void main(String[] args){

    
    //anonymous function or lambda
    // can only put in 1 parameter, following what is defined in Greetings
    // do not need to say it's a string (String n), because it knows it is a string. Inferring type from the template we give it in Greetings.
    //(name) = > {}
    Greetings hi = (n) -> {
      System.out.printf("Hello %s\n", n);
    };
    // call the function
    //hi is the interface, hello is the method
    hi.hello("fred");

    List<String> names = List.of("fred","barney","wilma","betty");
    System.out.printf("Say hello to %s\n", names);
    for (String n:names)
      apply(hi,n);

    toUpperCase("hello, world");

    //Any method that fits the signature can be used.
    //only for static method
    //can perform any operation so long you pass me a a string
    Greetings reverseCase = Lambda:: toUpperCase;
    System.out.printf("To uppercase %s\n", names);
    for (String n:names)
      apply(reverseCase,n);
  }
  
}
