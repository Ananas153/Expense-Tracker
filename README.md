# How to use this Expense Tracker

Program written in Java. To build a Jar executable file, use the command ```mvn clean package``` The executable is stored in the _target_ folder of the project.
The file name is _Expense-Tracker-1.0-SNAPSHOT.jar_

### Project URL : https://roadmap.sh/projects/expense-tracker

## Command:
**Add** an expense: ```java -jar Expense-Tracker-1.0-SNAPSHOT.jar add --description "description of the expense" --amount <amount of $$$>``` If the CSV file doesn't exist, it will be created in the _resources_ folder 
of the project.

**List** list all expenses: ```java -jar Expense-Tracker-1.0-SNAPSHOT.jar list```

**Summary** 
  1. Total of the list: ```java -jar Expense-Tracker-1.0-SNAPSHOT.jar summary```
  2. By month of the current year : ````java -jar Expense-Tracker-1.0-SNAPSHOT.jar summary --month <month as number ex: May = 5>````

**Update** an expense by its **ID**: ````java -jar Expense-Tracker-1.0-SNAPSHOT.jar update --id <id of expense> --date <new date> --description <new description> --amount <new $$$>````

**Delete** an expense by its **ID**: ````java -jar Expense-Tracker-1.0-SNAPSHOT.jar delete --id <id of expense>````

## Minor inconvenience:
For now the update feature require all of the flag.
After deleting an expense in an existing list, then add a new expense, the new expense have the same ID as an already item. 

## Possible Improuvement:
  1. Make the requirement for flag in Update feature optional.
  2. Improve the error and edges cases handling, can't just all make them in Main class (I guess).
  3. Add filter by categories feature.
