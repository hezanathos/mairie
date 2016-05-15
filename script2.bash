
#!/bin/sh
while read line; do  
	arr=$(echo $line | tr "-" "\n")  
	i=0;
	echo ${arr[0]}
	

done < fichier.txt