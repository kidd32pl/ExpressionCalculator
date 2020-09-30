**Expression Calculator**

To compile project use:

```
mvn clean install
```

To run application:

```
java -jar ExpressionCalculator.jar <input_path> <output_path>
 - input_path - path to the input files folder
 - output_path - path to output files folder
```

You should be able to add your own classes for expressions if you will follow some basic rules:
- new expression class has to implement interface ICalculable
- name of your class has to be the same as name of the expression tag in xml file (i.e. tag <addition> need to have class Addition java
- put class in com.kidd32pl.model package
- create methods add<name_of_the_field> for each xml tag in operation (i.e. for <factor> you need to have void method addFactor)
- elements of the expression has to be ICalculable type. For Integers use SimpleValue class
