<?php

session_start();

$bdd = new PDO('mysql:host=localhost;dbname=vdev;charset=utf8', 'root', 'root');


?>


<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AGRUR</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style/style.css">
  </head>

  <body style="background-image: url('style/fondAgrur.png');">

  <header class="headbar">
    <div class="container-fluid">
        <div class="text-right ">
            <ul>
                <li class="text_right">
                    <a href="index.html" class="btn btn-xs btn-warning"><span class="glyphicon glyphicon-log-out"></span> Deconnexion</a>
                </li>
            	</ul>
        	</div>
    	</div>
	</header>
	
		<img class="img_titre" src="style/titre.png">
		
	
    <div class="container">
        <div class="row">
            <div class="col-md-12 principal_block">
            <h3 class="center_title"><b>ESPACE ADMINISTRATEUR</b></h3>
            <br>
            
                <hr class="black_hr">

                <div class="row">
                    <div class="buttongroup col-md-offset-2 col-md-8 option_profil">
                        <div class="btn-group btn-group-justified" role="group" aria-label="sign">
                            <a type="button" class="btn btn-default" id="affichage_produc" ><b>PRODUCTEURS</b></a>
                            <a type="button" class="btn btn-default" id="affichage_client"><b>CLIENTS</b></a>
                        </div>
                    </div>
                </div>
                <br><br>
                
                <div class="row" id="produc">
                    <h4 class="sous_titre_dossier_patient"><b>LISTE DES PRODUCTEURS</b></h4>
                    <hr class="black_hr">
                        <div class="table-responsive">
                            <table class="table">
                                <tr>
                                    <th>Nom</th>
                                    <th>Prenom</th>
                                    <th>Mail</th>
                                    <th>Adresse</th>
                                    <th>Telephone</th>
                                    <th>Adhérent</th>
                                    <th>Certification</th>
                                    <th>Modifier les informations</th>
                                </tr>
                                <?php

                                    $reqProd = $bdd->query('SELECT producteur.nom, producteur.prenom, producteur.mail, producteur.adresse, producteur.tel, producteur.idCertif, producteur.dateAdherent FROM  producteur ');

                                    while($tab = $reqProd->fetch()){
                                        /*$timestamp = strtotime($tab['dateCond']);
                                        $dateCond = date("d-m-Y", $timestamp);

                                        $timestamp2 = strtotime($tab['dateLiv']);
                                        $dateLiv = date("d-m-Y", $timestamp);*/

                                        echo "<tr>";
                                            echo "<th>".$tab['nom']."</th>";
                                            echo "<th>".$tab['prenom']."</th>";
                                            echo "<th>".$tab['mail']."</th>";
                                            echo "<th>".$tab['adresse']."</th>";
                                            echo "<th>".$tab['tel']."</th>";
                                            if(is_null($tab['dateAdherent'])){
                                                echo "<th> Non adhérent </th>";
                                            }
                                            else{
                                                echo "<th> Adhérent depuis ".$tab['dateAdherent']."</th>";
                                            }
                                            if($tab['idCertif'] == 0){
                                                echo "<th> Aucune </th>";
                                            }else{
                                                echo "<th> Agriculteur biologique </th>";
                                            }

                                            echo '<th><a href="modifInfos.php?nom='.$tab['nom'].'"> ici </a></th>';
                                        echo "</tr>";
                                    }


                                ?>
                                    
                            </table>
                            <br>
                        </div>
                        
                    </div>

                        <div class="row" id="client">
                            <h4 class="sous_titre_dossier_patient"><b>LISTE DES CLIENTS</b></h4>
                            <hr class="black_hr">
                                <div class="table-responsive">
                                <table class="table">
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>Mail</th>
                                        <th>Adresse</th>
                                        <th>Téléphone </th>
                                        <th>Nombre de commande</th>
                                        <th>Voir le profil</th>
                                    </tr>
                                    <?php

                                    $reqClient = $bdd->query('SELECT client.nom, client.prenom, client.mail, client.adresse, client.tel FROM  client ');
                                    

                                    while($tab = $reqClient->fetch()){
                                        /*$timestamp = strtotime($tab['dateCond']);
                                        $dateCond = date("d-m-Y", $timestamp);

                                        $timestamp2 = strtotime($tab['dateLiv']);
                                        $dateLiv = date("d-m-Y", $timestamp);*/

                                        echo "<tr>";
                                            echo "<th>".$tab['nom']."</th>";
                                            echo "<th>".$tab['prenom']."</th>";
                                            echo "<th>".$tab['mail']."</th>";
                                            echo "<th>".$tab['adresse']."</th>";
                                            echo "<th>".$tab['tel']."</th>";

                                            $reqNbCommande = $bdd -> query('SELECT count(commande.idCommande) as nbCommande FROM commande WHERE commande.nomClient= \''.$tab['nom'].'\' ORDER BY commande.nomClient');

                                            $donnees=$reqNbCommande->fetch();
                                            $nbCommande=$donnees['nbCommande'];

                                            echo "<th>".$nbCommande."</th>";
                                            echo '<td><a href="#"><span class="glyphicon glyphicon-eye-open"></span></a></td>';
                                        echo "</tr>";
                                    }


                                ?>
                                </table>
                                <br>
                            </div>
                        </div>
                        <br>

            </div>
        </div>
	</div>


<br><br><br>
<footer class="container-fluid">
    <p class="text-center copyright">AGRUR<br> © Copyright 2017 // DUBRULLE / OSTROWSKI / GIAQUINTO</p>
</footer>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

<script>
    $("#produc").hide();
    $("#client").hide();

    $("#affichage_produc").click(function () {
        $("#produc").show();
        $("#client").hide();
        $("#affichage_produc").addClass("btn-warning");
        $("#affichage_client").removeClass("btn-warning");
    });

    $("#affichage_client").click(function () {
        $("#produc").hide();
        $("#client").show();
        $("#affichage_client").addClass("btn-warning");
        $("#affichage_produc").removeClass("btn-warning");
    });  
</script>

  </body>
</html>