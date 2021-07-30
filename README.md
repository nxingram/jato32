# jato32
##### Eclipse plugin ObjectAid (UML drawing tool)
- https://www.programmersought.com/article/1129108421/

# XAMPP Errori vari
###### database mysql corrotto, tabella db

1034 - File chiave errato per la tabella : 'db'; prova a riparalo
 
Controllare stato dellla tabella:

USE mysql;
CHECK TABLE db;

Se restituisce tabella corrotta, riparala usando

USE mysql;
REPAIR TABLE db;
CHECK TABLE db;

Dovresti ottenere lo stato come OK . 

###### XAMPP - MySQL shutdown unexpectedly

https://stackoverflow.com/questions/18022809/xampp-mysql-shutdown-unexpectedly


STOP! Please do NOT delete **ibdata1** file!

Deleting this file is like playing a Russian roulette with your databases, 
it could work and restablish everything, but also, probably could leave unusable every database you have.

Instead, first try using the MySQL backup folder which is included with XAMPP. So do the next:

    Rename the folder mysql/data to mysql/data_old (you can use any name)
    Create a new folder mysql/data
    Copy the content that resides in mysql/backup to the new mysql/data folder
    Copy all your database folders that are in mysql/data_old to mysql/data (skipping the mysql, performance_schema, and phpmyadmin folders from data_old)
    Finally copy the **ibdata1** file from mysql/data_old and replace it inside mysql/data folder
    Start MySQL from XAMPP control panel

And, voilà!
