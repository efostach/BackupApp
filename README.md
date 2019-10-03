# Backup Application

Current application allows user to make a backup files from "Files" directory to "Backup" directory.
Backup files has prefix 'backup_' before the original file name.

It's used java.util.concurrency library. For maximizing performance the app creates the number of thread pools equals CPU count.