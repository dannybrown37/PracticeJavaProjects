package JavaBasics;

public class PythonToJavaNotes {
	public static void main(String[] args) {
        // Java for Python Programmers
        // https://www.youtube.com/watch?v=fL7bVIpwzxA
        
        // MATH BASICS
        int a = 7;
        int b = 8;
        int c = 9;
        double d = 7.0; // float exists, but we should always use double
        double e = 8.0;
        System.out.println(a);
        System.out.println((double)a/b); // casting int a as a double
        System.out.println((int)(d/e)); // casting result of division as int
        System.out.println(Math.pow(a,b)); // a raised to the power of b
                                           // Math.pow returns a double
        System.out.println(Math.sqrt(c)); // returns square root as double
        System.out.println(Math.E); // property E
        
        
        // STRING BASICS
        // characters use single quotations and store only single characters
        char someChar = 'z';
        System.out.println(someChar);
        
        // strings are objects
        // heres a quick primer on comparing different strings as objects
        String someString = "hello";
        String someOtherString = "hello";
        System.out.println(someString == someOtherString); // true
        
        String third = new String("hello");
        System.out.println(someString == third); // false
        // someString and someOtherString are aliases, pointing at the same obj
        // because we used the new operator with third, it's a different obj
        System.out.println(someString.equals(third)); // true
        
        StringBuilder bobTheBuilder = new StringBuilder();
        bobTheBuilder.append("hello");
        String bobTheString = bobTheBuilder.toString();
        System.out.println(someString == bobTheString); // false
        System.out.println(someString.equals(bobTheString)); // true
        // Strings in Java are objects; consider whether they are referencing
        // the same memory location or if they are actually the same object
        
        // CONCATANATING STRINGS
        System.out.println(someString+someOtherString);
        System.out.println(someString + " " + someOtherString);
        
        
        // ARRAYS and FOR LOOPS
        // arrays are contiguous in memory and EXTREMELY fast
        // way faster than a Python list
        // 2.14 billion object limit in an array
        // can't mix data types 
        int [] arrayA = new int [10];
        arrayA[0] = 7;
        // type array variableName = newOperator typeAgain howLargeToStartAs
        System.out.println(arrayA); // prints a gross memory location
        // two different ways to for loop through the array
        for(int element: arrayA){ 
            System.out.println(element);
        }
        for(int i = 0; i < arrayA.length; i++){
            System.out.println(arrayA[i]);
        }
        
        int [] someNums = {0,1,2,3,4,5,6,7,8,9,10,11}; // initialize values
        for(int element: someNums){ 
            System.out.println(element);
        }
        
        
        // CONSTANTS
        final int [] MORE_NUMS = {0,1,2,3,4,5,6,7,8,9,10,11}; // constant array
        MORE_NUMS[7] = 11;
        System.out.println(MORE_NUMS[7]); // THIS ACTUALLY WORKS!
        // despite final being the const keyword, doesn't act as expected
        final int AB = 7;
        System.out.println(AB);
        // AB = 9; // returns an error! cannot assign a value to a final var
        
        
        // IF/ELSE STATEMENTS
        if (8==8){
            System.out.println("It is 8!");
        } else if (9==9){
            System.out.println("It is 9!");
        } else {
            System.out.println("It is something else!");
        }
        
        
        // BOOLEANS
        System.out.println(true && true); // and operator
        System.out.println(true || false); // or operator
        System.out.println(!true || !true); // not operator
        int x = 7;
        int y = 8;                // if true    if false
        System.out.println(x > y ? "hello" : "not hello"); // ternary operator
        
        
        // WHILE LOOP check before running the first time
        int count = 0;
        while(count < 10){
            count++;
            System.out.println("Test" + count);
        }
        
        // DO WHILE LOOPS check after running the first time
        count = 10;
        do {
            count++;
            System.out.println("Test" + count); 
        } while (count < 10);
        // this runs one time even though test fails because it runs first
        
        // FOR LOOPS
        for(int i = 0; i < 10; i++){
            System.out.println(i); // prints 0-9
        }
        for(int i = 0; i < 10; i+=2){
            System.out.println(i); // prints 0 2 4 6 8
        }
        for(int i = 10; i > 0; i--){
            System.out.println(i); // prints 10-1
        }
        int [] someInts = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        for(int num: someInts){
            System.out.println(num); // prints 0-12
        }
        int [] otherInts = new int [13];
        for(int i = 12; i < (otherInts.length + 12); i++){
            otherInts[i-12] = i; // assigns 12-24
            System.out.println(otherInts[i-12]); // prints 12-24
        }   
        
    }
}
