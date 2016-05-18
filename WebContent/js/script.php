<?php
echo "yes1";
$bddl = 'root';
$bddmdp = 'root';
$bddName = 'acces';
$pdo = new PDO ( "mysql:host=127.0.0.1;dbname=" . $bddName, $bddl, $bddmdp );
	$pdo->setAttribute ( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
	$res = $pdo->query ( "SELECT * FROM `acces`");
	$res->execute (); 
	$data = $res->fetch ( PDO::FETCH_ASSOC);
		if (data[a] == 1){
			echo "yes";
		$pdo->setAttribute ( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
	$res = $pdo->query ( "UPDATE acces SET a=0;");
	$res->execute (); }
	
	
	
	echo $data['a'];