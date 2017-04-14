<?php

session_start();

//Connexion à la base de données
$bdd = new PDO('mysql:host=localhost;dbname=ppe;charset=utf8', 'root', 'root');

$mail = $_SESSION['mail'];

$reqInfo = $bdd->query('SELECT nom, prenom, adresse, tel, dateAdherent, idCertif FROM producteur WHERE mail = \''.$mail.'\'');

while($tab = $reqInfo->fetch()){
    $nom = $tab['nom'];
    $prenom = $tab['prenom'];
    $adresse=$tab['adresse'];
    $tel = $tab['tel'];
    $dateAdherent = $tab['dateAdherent'];
    $idCertif=$tab['idCertif'];
}

$reqNbCommande = $bdd -> query('SELECT count(commande.idCommande) as nbCommande FROM commande, producteur WHERE commande.nomProd=producteur.nom and producteur.mail = \''.$mail.'\' ORDER BY commande.idCommande');

$donnees=$reqNbCommande->fetch();
$nbCommande=$donnees['nbCommande'];


$reqNbVergers = $bdd -> query('SELECT count(vergers.idVergers) as nbVerger FROM vergers, producteur WHERE vergers.nomProd=producteur.nom and producteur.mail = \''.$mail.'\' ORDER BY vergers.idVergers');

$donneesVergers=$reqNbVergers->fetch();
$nbVergers=$donneesVergers['nbVerger'];
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
            <br>
                <p><b>Bonjour</b>, bon retour parmis nous <?php echo $nom." ".$prenom; ?></p>
                <hr class="black_hr">
                <div class="row">
                    <div class="col-md-3">
                        <p>
                            <ul>
                                <li>Adresse mail : <?php echo $mail; ?></li>
                                <li>Téléphone : <?php echo $tel; ?></li>
                            </ul>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <p>
                            <ul>
                                <li>Certification : <?php if($idCertif == 0): echo "Aucune certification"; else: echo "Agriculteur biologique"; endif; ?></li>
                                <li>Adhérent : <?php if($dateAdherent == "2000-01-01"): echo "Non"; else : echo "Oui"; endif; ?></li>
                                <?php if($dateAdherent == "2000-01-01"): echo ""; else : echo "<li>Date adhésion : ".$dateAdherent."</li>"; endif; ?>
                            </ul>
                        </p>
                    </div>
                </div>


                <div class="row">
                    <div class="buttongroup col-md-offset-2 col-md-8 option_profil">
                        <div class="btn-group btn-group-justified" role="group" aria-label="sign">
                            <a type="button" class="btn btn-default" id="affichage_verger" ><b>VERGERS</b>  &nbsp<span class="badge"><?php echo $nbVergers; ?> </a>
                            <a type="button" class="btn btn-default" id="affichage_client"><b>CLIENTS</b></a>
                            <a type="button" class="btn btn-default" id="affichage_commande"><b>COMMANDE</b> &nbsp<span class="badge"><?php echo $nbCommande; ?></span></a>
                        </div>
                    </div>
                </div>
                <br><br>
                
                <div class="row" id="verger">
                    <h4 class="sous_titre_dossier_patient"><b>RECAPITULATIF</b></h4>
                    <hr class="black_hr">
                        <div class="table-responsive">
                            <table class="table">
                                <tr>
                                    <th>Nom</th>
                                    <th>Superficie</th>
                                    <th>Densité</th>
                                    <th>Variété Noix</th>
                                    <th>Calibre (en mm)</th>
                                    <th>Commune</th>
                                </tr>

                                <?php

                                    $reqVergers = $bdd->query('SELECT vergers.nom, vergers.superficie, vergers.densite, vergers.varieteNoix, vergers.calibre, vergers.commune FROM producteur, vergers WHERE vergers.nomProd=producteur.nom  and producteur.mail = \''.$mail.'\' GROUP BY vergers.nom' );

                                    while($tab = $reqVergers->fetch()){

                                        /*$timestamp = strtotime($tab['dateCond']);
                                        $dateCond = date("d-m-Y", $timestamp);

                                        $timestamp2 = strtotime($tab['dateLiv']);
                                        $dateLiv = date("d-m-Y", $timestamp);*/

                                        echo "<tr>";
                                            echo "<th>".$tab['nom']."</th>";
                                            echo "<th>".$tab['superficie']."</th>";
                                            echo "<th>".$tab['densite']."</th>";
                                            echo "<th>".$tab['varieteNoix']."</th>";
                                            echo "<th>".$tab['calibre']."</th>";
                                            echo "<th>".$tab['commune']."</th>";
                                        echo "</tr>";
                                    }


                                ?>

                            </table>
                            <br>
                            

                        </div>
                        <a href="ajouterVergers.php" class="btn btn-xs btn-warning bouton_ajout_verger"><span class="glyphicon glyphicon-plus"></span> Ajouter un verger</a>
                            <br>

                        </div>

                        <div class="row" id="client">
                            <h4 class="sous_titre_dossier_patient"><b>LISTE DES CLIENTS</b></h4>
                            <hr class="black_hr">
                                <div class="table-responsive">
                                <table class="table">
                                    <tr>
                                        <th>Nom</th>
                                        <th>Prenom</th>
                                        <th>Adresse</th>
                                        <th>Téléphone </th>
                                    </tr>

                                    <?php

                                    $reqCommande = $bdd->query('SELECT client.nom, client.prenom, client.adresse, client.tel FROM commande, producteur, client WHERE commande.nomProd=producteur.nom and commande.nomClient=client.nom and producteur.mail = \''.$mail.'\' GROUP BY client.nom' );

                                    while($tab = $reqCommande->fetch()){
                                        /*$timestamp = strtotime($tab['dateCond']);
                                        $dateCond = date("d-m-Y", $timestamp);

                                        $timestamp2 = strtotime($tab['dateLiv']);
                                        $dateLiv = date("d-m-Y", $timestamp);*/

                                        echo "<tr>";
                                            echo "<th>".$tab['nom']."</th>";
                                            echo "<th>".$tab['prenom']."</th>";
                                            echo "<th>".$tab['adresse']."</th>";
                                            echo "<th>".$tab['tel']."</th>";
                                        echo "</tr>";
                                    }


                                ?>
                                </table>
                                <br>
                            </div>

                            

                        </div>
                        <br>


                    <div class="row" id="commande">
                    <h4 class="sous_titre_dossier_patient"><b>RECAPITULATIF</b></h4>
                    <hr class="black_hr">
                        <div class="table-responsive">
                            <table class="table">
                                <tr>
                                    <th>Numéro de commande</th>
                                    <th>Nom du client</th>
                                    <th>Variété Noix</th>
                                    <th>Calibre (en mm)</th>
                                    <th>Quantité</th>
                                    <th>Type de conditionnement</th>
                                    <th>Date de conditionnement</th>
                                    <th>Date de livraison</th>

                                </tr>
                                <?php

                                    $reqCommande = $bdd->query('SELECT commande.idCommande, commande.nomClient, commande.varieteNoix, commande.calibre, commande.quantite, commande.type, commande.dateCond, commande.dateLiv FROM commande, producteur WHERE commande.nomProd=producteur.nom and producteur.mail = \''.$mail.'\'');

                                    while($tab = $reqCommande->fetch()){
                                        /*$timestamp = strtotime($tab['dateCond']);
                                        $dateCond = date("d-m-Y", $timestamp);

                                        $timestamp2 = strtotime($tab['dateLiv']);
                                        $dateLiv = date("d-m-Y", $timestamp);*/

                                        echo "<tr>";
                                            echo "<th>".$tab['idCommande']."</th>";
                                            echo "<th>".$tab['nomClient']."</th>";
                                            echo "<th>".$tab['varieteNoix']."</th>";
                                            echo "<th>".$tab['calibre']."</th>";
                                            echo "<th>".$tab['quantite']."</th>";
                                            echo "<th>".$tab['type']."</th>";
                                            echo "<th>".$tab['dateCond']."</th>";
                                            echo "<th>".$tab['dateLiv']."</th>";
                                        echo "</tr>";
                                    }


                                ?>

                            </table>
                            <br>
                        </div>
                        

                </div>
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
    $("#verger").hide();
    $("#client").hide();
    $("#commande").hide();

    $("#affichage_verger").click(function () {
        $("#verger").show();
        $("#client").hide();
        $("#commande").hide();
        $("#affichage_verger").addClass("btn-warning");
        $("#affichage_client").removeClass("btn-warning");
        $("#affichage_commande").removeClass("btn-warning");
    });

    $("#affichage_client").click(function () {
        $("#verger").hide();
        $("#client").show();
        $("#commande").hide();
        $("#affichage_verger").removeClass("btn-warning");
        $("#affichage_client").addClass("btn-warning");
        $("#affichage_commande").removeClass("btn-warning");

    });

    $("#affichage_commande").click(function () {
        $("#verger").hide();
        $("#client").hide();
        $("#commande").show();
        $("#affichage_verger").removeClass("btn-warning");
        $("#affichage_client").removeClass("btn-warning");
        $("#affichage_commande").addClass("btn-warning");
    });
</script>

  </body>
</html>