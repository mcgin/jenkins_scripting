
    class Person {  
        String firstname  
        String lastname  
        int age  
    }  
     
    println new Person().metaClass.methods*.name.sort().unique()
