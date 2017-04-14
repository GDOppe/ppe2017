<?php

session_start();

//Connexion à la base de données
$bdd = new PDO('mysql:host=localhost;dbname=ppe;charset=utf8', 'root', 'root');

$mail = $_SESSION['mail'];

$reqInfo = $bdd->query('SELECT nom, prenom, adresse, tel FROM client WHERE mail = \''.$mail.'\'');

while($tab = $reqInfo->fetch()){
    $nom = $tab['nom'];
    $prenom = $tab['prenom'];
    $adresse=$tab['adresse'];
    $tel = $tab['tel'];
}

$reqNbCommande = $bdd -> query('SELECT count(commande.idCommande) as nbCommande FROM commande, client WHERE commande.nomClient=client.nom and client.mail = \''.$mail.'\' ORDER BY commande.idCommande');

$donnees=$reqNbCommande->fetch();
$nbCommande=$donnees['nbCommande'];


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
<form method="post">
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
            <br>
                <p><b>Bonjour</b>, bon retour parmi nous <?php echo $nom." ".$prenom; ?></p>
                <hr class="black_hr">
                <div class="row">
                    <div class="col-md-3">
                        <p>
                            <ul>
                                <li>Adresse mail : <?php echo $mail; ?> </li>
                                <li>Téléphone : <?php echo $tel; ?> </li>
                            </ul>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <p>
                            <ul>
                                <li>Nombre de commande : <?php echo $nbCommande; ?></li>
                            </ul>
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="buttongroup col-md-offset-2 col-md-8 option_profil">
                        <div class="btn-group btn-group-justified" role="group" aria-label="sign">
                            <a type="button" class="btn btn-default" id="affichage_commande"><b>COMMANDE</b></a>
                        </div>
                    </div>
                </div>
                <br><br>
                <div class="row">
                    <div class="col-md-5">
                        <a href="passerCommande.php" class="btn btn-xs btn-warning"><span class="glyphicon glyphicon-usd"></span> Passer une commande</a>
                    </div>
                </div>
                <br><br>
                <div class="table-responsive">
                    <table class="table">
                        <tr>
                            <th>Numéro commande</th>
                            <th>Nom Producteur</th>
                            <th>Variété de noix</th>
                            <th>Calibre</th>
                            <th>Quantité</th>
                            <th>Type conditionnement</th>
                            <th>Date conditionnement</th>
                            <th>Date livraison</th>
                            <th>Pdf</th>
                        </tr>
                        <?php

                        $reqCommande = $bdd->query('SELECT commande.idCommande, commande.nomProd, commande.varieteNoix,commande.calibre, commande.quantite, commande.type, commande.dateCond, commande.dateLiv FROM commande, client WHERE commande.nomClient=client.nom and client.mail = \''.$mail.'\'');

                        while($tab = $reqCommande->fetch()){
                            /*$timestamp = strtotime($tab['dateCond']);
                            $dateCond = date("d-m-Y", $timestamp);

                            $timestamp2 = strtotime($tab['dateLiv']);
                            $dateLiv = date("d-m-Y", $timestamp);*/

                            echo "<tr>";
                                echo "<th>".$tab['idCommande']."</th>";
                                echo "<th>".$tab['nomProd']."</th>";
                                echo "<th>".$tab['varieteNoix']."</th>";
                                echo "<th>".$tab['calibre']."</th>";
                                echo "<th>".$tab['quantite']."</th>";
                                echo "<th>".$tab['type']."</th>";
                                echo "<th>".$tab['dateCond']."</th>";
                                echo "<th>".$tab['dateLiv']."</th>";
                                echo "<th> <a href='pdf.php?idCommande=".$tab['idCommande']."'> ici </a> </th>";
                             echo "</tr>";
                             
                        }


                        ?>
                    </table>
                </div>

            </div>
        </div>
    </div>
</form>

    
<br><br><br><br><br><br>
<footer class="container-fluid">
    <p class="text-center copyright">AGRUR<br> © Copyright 2017 // DUBRULLE / OSTROWSKI / GIAQUINTO</p>
</footer>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>