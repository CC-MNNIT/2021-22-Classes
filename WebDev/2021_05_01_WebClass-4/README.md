# Web Development Class - IV

#### May 01, 2021

<hr>

<div align="center"><h2>Database</h2></div>

*   ### What is Data?

    * Data can be defined as a **collection** of facts and records on which we can apply reasoning or can-do discussion or some calculation.
    * Data can exist in form of **graphics, reports, tables, text, etc**. that represents every kind of information, that allows easy retrieval, updating, analysis, and output of data by systematically organized or structured repository of indexed information.

*   ### What is Database?

    * Database is a collection of **interrelated** data.
    * Inside a database, the data is **recorded in a table** which is a collection of rows, columns, etc.

*   ### Why do we need database?

    * Large volumes of data can be stored in one place.
    * Multiple users can **read** and **modify** the data at the same time.
    * Databases are **searchable** and **sortable**, so the data you need can be found quick and easily.

*   ### What is DBMS?

    * It stands for **Database Management Systems**.
    * Database management system is a software which can be used to manage the data by **storing** it on to the database and by **retrieving** and **manipulating** the data from the database.

*   ### Types of Database

    * Databases are broadly divided into **two** types:-
        1. **Relational Database** - one that stores data in **tables**.
        2. **Non-relational Database** - that uses **different keys** where each key is associated with only one value in a collection. Think of it as a **dictionary**.

*   ### RDBMS Components/Terminologies

    * **Table or Relation** - A table is a collection of data represented in rows and columns. Each table has a name in database.
    * **Record or Tuple** - Each row of a table is known as record. It is also known as tuple.
    * **Field or Column Name or Attribute** - An individual piece of data in a record is known as a field, or attribute.
    * **Domain** - A domain is a set of permitted values for an attribute in table.
    * **Instance** - The data stored in database at a particular moment of time is called instance of database.
    * **Schema** - Design of a database is called the schema. Schema is only a structural view(design) of a database.
    * **Keys** - It is used for identifying unique rows from table. It also establishes relationship among tables.

*   ### Types of keys in DBMS

    * **Primary Key** – A primary is a column or set of columns in a table that **uniquely** identifies tuples (rows) in that table.
    * **Foreign Key** – Foreign keys are the columns of a table that points to the primary key of another table. They act as a **cross-reference** between tables.

*   ### SQL
    * SQL stands for **Structured Query Language**.
    * It is designed for managing data in a relational database management system (RDBMS).
    * It is pronounced as **S-Q-L** or sometime **See-Qwell**.
    * SQL is a database language, it is used for database creation, deletion, fetching rows, and modifying rows, etc.
    * SQL is based on relational algebra and tuple relational calculus.

*   ### SQL Datatypes
    * Data types are used to represent the **nature of the data** that can be stored in the database table.
    * For example, in a particular column of a table, if we want to store a **string** type of data then we will have to declare a **string data type** for this column.
    * Some of the MySQL datatypes are - 
        * **CHAR(size)** - Used to specify fixed length string. Size can be from **0 to 255** characters.
        * **VARCHAR(size)** - Used to specify a variable length string. Size can be from **0 to 65535** characters.
        * **INT(size)** - Used for integer value. The **size** parameter specifies the max display width that is 255.
        * **FLOAT(size, d)** - Used to specify a floating point number. Its **size** parameter specifies the total number of digits. The number of digits after the decimal point is specified by **d** parameter.  
        * **DATE** - It is used to specify date format **YYYY-MM-DD**.
    * There are many other datatypes present in SQL. You should explore them according to your needs and use-case.

*   ### SQL Syntax
    * SQL is not case sensitive (*Generally SQL keywords are written in uppercase*).
    * We can place a single SQL statement on one or multiple text lines.
    * SQL statements start with any of the **SQL commands/keywords** like `SELECT`, etc.
    * SQL statements ends with a **semicolon** (**;**). It separates two SQL statements.
    * **Example SQL Statement** - 
    ```sql
    SELECT registration_no FROM students;
    ```

*   ### SQL Commands
    * SQL commands are **instructions**. 
    * They are used to communicate with the database. 
    * They are also used to perform specific tasks, functions, and queries of data.
    * SQL can perform various tasks like **create a table**, **add data to tables**, **drop the table**, **modify the table**, **set permission for users**.
    * **Example** - `SELECT`, `INSERT`, `UPDATE`, `DELETE`, `ALTER`, `DROP` etc.

*   ### Types of SQL Commands
    * There are five types of SQL commands: 
        * **DDL**: Data Definition Language
        * **DML**: Data Manipulation Language
        * **DQL**: Data Query Language
        * **DCL**: Data Control Language
        * **TCL**: Transaction Control Language
    * **Note** - For now, focus only on **DDL**, **DML** and **DQL** commands.

    <div align="center"><img src="./images/dbms_sql_command.png" alt="DBMS_SQL_Commands" /></div>

*   ### Data Definition Languague (DDL)
    * DDL **changes the structure of the table** like creating a table, deleting a table, altering a table, etc.
    * Some commands under DDL - 
        * **CREATE** - It is used to create a database or a new table in the database.
            * Syntax (creating database) - 
            ```sql
            CREATE DATABASE database_name;
            ```
            * Syntax (creating a table) - 
            ```sql
            CREATE TABLE TABLE_NAME(COLUMN_NAME DATATYPES[,....]);
            ```
            * Example - 
            ```sql
            CREATE TABLE EMPLOYEE(Name VARCHAR(20), Email VARCHAR(100), DOB DATE);
            ```
        * **DROP** - It is used to delete both the *structure* and *records* stored in the table.
            * Syntax - 
            ```sql
            DROP TABLE TABLE_NAME;
            ```
            * Example - 
            ```sql
            DROP TABLE EMPLOYEE;
            ```
        * **ALTER** - It is used to alter the structure of the database. This change could be either to modify the characteristics of an **existing attribute** or probably to **add a new attribute**.
            * Syntax (add a new column) - 
            ```sql
            ALTER TABLE table_name ADD column_name (COLUMN DEFINITION);    
            ```
            * Syntax (modify existing column) - 
            ```sql
            ALTER TABLE table_name MODIFY (COLUMN DEFINITION....);  
            ```
            * Examples - 
            ```sql
            ALTER TABLE STU_DETAILS ADD (ADDRESS VARCHAR2(20));
            ALTER TABLE STU_DETAILS MODIFY (NAME VARCHAR2(20));  
            ```
        * **TRUNCATE** - It is used to delete all the rows from the table. The structure/schema of table is preserved.
            * Syntax - 
            ```sql
            TRUNCATE TABLE table_name;  
            ```
            * Example - 
            ```sql
            TRUNCATE TABLE EMPLOYEE;  
            ```

*   ### Data Manipulation Languague (DML)
    * DML commands are used to **modify the database**.
    * These commands are responsible for all form of changes in the database.
    * Some commands under DML -
        * **INSERT** -  It is used to **insert data** into the **row** of a table.
            * Syntax - 
            ```sql
            INSERT INTO TABLE_NAME (col1, col2, col3,.... col N) VALUES (value1, value2, value3, ...., valueN);  
            ```
            * Example - 
            ```sql
            INSERT INTO students (Name, Subject) VALUES ("Alice", "DBMS");  
            ```
        * **UPDATE** - This command is used to update or modify the value of a column in the table.
            * Syntax - 
            ```sql
            UPDATE table_name SET [column_name1= value1,...column_nameN = valueN] [WHERE CONDITION];
            ```
            * Example - 
            ```sql
            UPDATE students SET Name = 'Bob' WHERE Student_Id = '3';
            ```
        * **DELETE** - It is used to remove one or more row from a table.
            * Syntax - 
            ```sql
            DELETE FROM table_name [WHERE condition];
            ```
            * Example - 
            ```sql
            DELETE FROM students WHERE Name="Bob";  
            ```
*   ### Data Query Language (DQL)
    * DQL is used to **fetch** the data from the database.
    * DQL uses only one command - 
        * **SELECT** - It is used to select the attribute based on the condition described by `WHERE` clause.
            * Syntax - 
            ```sql
            SELECT expressions FROM TABLES WHERE conditions; 
            ```
            * Example - 
            ```sql
            SELECT emp_name FROM employee WHERE age > 20;  
            ```

*   ### SQL Clauses
    * **WHERE** - 
        * A `WHERE` clause in SQL is a data manipulation language statement.
        * It filters the records. It returns only those queries which **fulfill the specific conditions**.
        * It uses some conditional selection like `=`, `>`, `<`, `<=`, `>=`, `<>`.
        * `<>`  means **not equal to**.
        * Example - 
        ```sql
        SELECT s_name FROM students WHERE s_age >= 18;
        ```
    * **AND** and **OR** - 
        * Can be used to group multiple conditions.
        * Example - 
        ```sql
        SELECT s_name, s_age FROM students WHERE (s_age >= 18 AND cpi > 7.0);
        ```
    * **LIKE** - 