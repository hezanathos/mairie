
#!/bin/sh
while read line; do  
	arr=$(echo $line | cut -d "-" -f2)  
newPath=$(echo "./cleanDatas/"$arr".xml");
    cp $line $newPath  
done < fichier.txt