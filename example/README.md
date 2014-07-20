## Core Java Training - Application
Here you can find two folder, ` app ` and ` slideshow `. The ` app ` contained application binary file included template and slide data files. The content of slide data files are modifiable, but must follow the current rules.

### Usages
When application executed, it would find available template and slide data file (JSON). The slide data would be generated to **html** text, and then attached into template file.

The usage of the application do as the following:
```
java -jar CoreJavaTraining.jar [JSON_FILE_NAME]
```
Separates by whitespace to generate multiple slide data in paralel as the following:
```
java -jar CoreJavaTraining.jar [JSON_FILE_NAME_1] [JSON_FILE_NAME_2] [JSON_FILE_NAME_N]
```

### Result
Generated slide would be created into `slideshow/generated/` folder as **html** file.
