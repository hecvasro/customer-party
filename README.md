# customer-party

## Description
We have some customer records in a text file (customers.json) -- one customer per line,
JSON-encoded. We want to invite any customer within 100km of our Dublin office for some food and
drinks on us. Write a program that will read the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).
- You can use the first formula from [this Wikipedia article](https://en.wikipedia.org/wiki/Great-circle_distance) to calculate distance. Don't forget,
you'll need to convert degrees to radians.
- The GPS coordinates for our Dublin office are 53.339428, -6.257664.
- You can find the Customer list [here](https://gist.github.com/brianw/19896c50afa89ad4dec3).

## Implementation

### Stack
- Java
- Gradle
- IntelliJ IDEA CE

### Third-party libraries
- **[Gson](https://github.com/google/gson)**: A Java serialization/deserialization library to convert Java Objects into JSON and back.
- **[JCommander](https://github.com/cbeust/jcommander)**: Command line parsing framework for Java.
- **[JUnit](https://github.com/junit-team/junit4)**: A programmer-oriented testing framework for Java.

### Usage

```bash
./gradlew run -Pfile={file}
```

#### Parameters
**file**: File from which the list of customers will be read.

If no parameters are passed, a message indicating how the program should be used will be
displayed.