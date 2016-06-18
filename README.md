# Executable Jar
An archetype for creating simple executable JARs with all their dependencies in a ZIP file, including the Maven dependencies in a lib directory.

Ref: http://www.mycodefu.com/2013/05/simple-deployment-in-java.html

## Usage
Create a new maven based project in your IDE, selecting to start from an archetype with the following details:

```
Group ID: com.mycodefu
Artifact ID: executable-jar-archetype
Version: 1.0
```

### Packaging
Run a maven 'package' command:
```
mvn package
```
The package goal will:
Put all your dependencies into a folder next to your JAR package named 'lib'
Put the dependencies in your lib directory into the manifest of the JAR (no classpath!)
Put the main class entrypoint into the JAR manifest
Compress everything into a neat ZIP file ready to deploy anywhere

### Running
When you unzip your packaged software, you can run it using the following command:

```
java -jar executable-jar.jar
```

