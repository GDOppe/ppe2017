<?php
session_start();

$bdd = new PDO('mysql:host=localhost;dbname=ppe;charset=utf8', 'root', 'root');

$mail=$_SESSION['mail'];
$erreur="";
$req = $bdd->query('SELECT nom FROM client WHERE mail = \''.$mail.'\'');
//$reqInfo = $bdd->query('SELECT nom, prenom, adresse, tel, dateAdherent, idCertif FROM producteur WHERE mail = \''.$mail.'\'');

$donnee = $req->fetch();
$nomClient=$donnee['nom'];


if(isset($_POST['validerCommande'])){
  $nomProd = $_POST['nomProd'];
  $variete = $_POST['variete'];
  $calibre=$_POST['calibre'];
  $qte=$_POST['qte'];
  $typeCond=$_POST['typeCond'];
  $dateCond=$_POST['dateCond'];
  $dateLivraison=$_POST['dateLivraison'];
  

  if(!empty($nomProd) && !empty($calibre) && !empty($qte) && !empty($typeCond) && !empty($dateCond) && !empty($dateLivraison)){
    $bdd->exec("INSERT INTO commande(nomProd, nomClient, varieteNoix, calibre, quantite, type, dateCond, dateLiv) VALUES('$nomProd', '$nomClient', '$variete', $calibre,  $qte, '$typeCond', '$dateCond', '$dateLivraison')");
    header('Location: view_user.php');
    exit();
  }
  else{
    $erreur = "Un des champs est vide";
  }
}



?><!DOCTYPE html>
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
                <li class="text_left">
                    <a href="index.html" class="btn btn-xs btn-warning"><span class="glyphicon glyphicon-home"></span>
                        Accueil</a>
                </li>
            	</ul>
        	</div>
    	</div>
	</header>
	
		<img class="img_titre" src="style/titre.png">
	
    <div class="container">
        <div class="row">
            <div class="block_inscription">
                <form action="passerCommande.php" class="form-horizontal" method="post">
                    <fieldset>

                    <!-- Form Name -->
                    <h3 class="center_title"><b>PASSER COMMANDE</b></h3>
                    <hr class="black_hr">
                    <br>

                    

                    <!-- Text input-->
                    <div class="form-group">
                      <div class="row">
                        <label class="col-md-4 control-label" for="variete">Variété de noix</label>  
                      <div class="col-md-4">
                      <!--<input id="variete" name="variete" type="text" placeholder="Variété" class="form-control input-md">-->

                      <select name="variete" class = "form-control input-md">
                        <option value="choix"> Veuillez sélectionner votre variété de noix </option> 
                        <option value="franquette"> Franquette </option> 
                        <option value="mayette"> Mayette </option>
                        <option value="parisienne"> Parisienne</option>
                      </select>
                      </div>
                      <div class="col-md-3">
                          <button id="button" name="rechercher" class="btn btn-warning">Rechercher</button><br>
                      </div>
                      </div>
                      
                    </div>

                    <?php

                    if(isset($_POST['rechercher'])){

                      $variete = $_POST['variete'];
                      
                      if($variete == "franquette"){
                        $franquette = $bdd->query('SELECT nomProd FROM vergers WHERE varieteNoix = "franquette" GROUP BY nomProd');

                        $nbrFranquette = $franquette->rowCount();

                        while($tabFranquette = $franquette->fetch()){
                          $ntm = "franquette";
                          echo '<div class="form-group">';
                          echo '<label class="col-md-4 control-label" for="nomProd">On peut vous proposer ce(s) producteur(s) : </label>';
                          echo '<div class="col-md-4">';

                          echo '<select name="nomProd" class = "form-control input-md">';
                          echo '<option value="choix"> Veuillez sélectionner votre variété de noix </option>' ;
                          echo '<option value="'.$tabFranquette['nomProd'].'"> '.$tabFranquette['nomProd'].' </option>';
                          echo '</select>';
                          echo '</div>';
                          echo '</div>';
                        }
                        if($nbrFranquette == 0){
                          echo '<div class="form-group">';
                          echo '<label class="col-md-4 control-label" for=""></label>';
                          echo '<div class="col-md-6">';
                          echo '<label for="typeCond">Aucun de nos producteurs produit cette variété de noix</label>';
                          echo '</div>'; 
                          echo '</div>';     
                        }
                      }

                        if($variete == "mayette"){
                        $mayette = $bdd->query('SELECT nomProd FROM vergers WHERE varieteNoix = "mayette" GROUP BY nomProd');

                        $nbrMayette = $mayette->rowCount();

                        while($tabMayette = $mayette->fetch()){
                          $ntm = "mayette";
                          echo '<div class="form-group">';
                          echo '<label class="col-md-4 control-label" for="nomProd">On peut vous proposer ce(s) producteur(s) : </label>';
                          echo '<div class="col-md-4">';

                          echo '<select name="nomProd" class = "form-control input-md">';
                          echo '<option value="choix"> Veuillez sélectionner votre variété de noix </option>' ;
                          echo '<option value="'.$tabMayette['nomProd'].'"> '.$tabMayette['nomProd'].' </option>';
                          echo '</select>';
                          echo '</div>';
                          echo '</div>';
                        }

                        if($nbrMayette == 0){
                          echo '<div class="form-group">';
                          echo '<label class="col-md-4 control-label" for=""></label>';
                          echo '<div class="col-md-6">';
                          echo '<label for="typeCond">Aucun de nos producteurs produit cette variété de noix</label>';
                          echo '</div>'; 
                          echo '</div>';     
                        }
                      }

                      if($variete == "parisienne"){
                        $parisienne = $bdd->query('SELECT nomProd FROM vergers WHERE varieteNoix = "parisienne" GROUP BY nomProd');

                        $nbrParisienne = $parisienne->rowCount();

                        while($tabParisienne = $parisienne->fetch()){
                          $ntm = "parisienne";
                          echo '<div class="form-group">';
                          echo '<label class="col-md-4 control-label" for="nomProd">On peut vous proposer ce(s) producteur(s) : </label>';
                          echo '<div class="col-md-4">';

                          echo '<select name="nomProd" class = "form-control input-md">';
                          echo '<option value="choix"> Veuillez sélectionner votre variété de noix </option>' ;
                          echo '<option value="'.$tabParisienne['nomProd'].'"> '.$tabParisienne['nomProd'].' </option>';
                          echo '</select>';
                          echo '</div>';
                          echo '</div>';
                        }

                        if($nbrParisienne == 0){
                          echo '<div class="form-group">';
                          echo '<label class="col-md-4 control-label" for=""></label>';
                          echo '<div class="col-md-6">';
                          echo '<label for="typeCond">Aucun de nos producteurs produit cette variété de noix</label>';
                          echo '</div>'; 
                          echo '</div>';     
                        }
                      }
                    }


                    ?>

                    
                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="calibre">Calibre</label>  
                      <div class="col-md-4">
                      <input id="calibre" name="calibre" type="text" placeholder="Calibre" class="form-control input-md">
                      <!--<span class="help-block">Type de conditionnement</span>  -->
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="qte">Quantité</label>  
                      <div class="col-md-4">
                      <input id="qte" name="qte" type="text" placeholder="Quantité" class="form-control input-md">
                      <!--<span class="help-block">Type de conditionnement</span>  -->
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="typeCond">Type conditionnement</label>  
                      <div class="col-md-4">
                      <input id="typeCond" name="typeCond" type="text" placeholder="Type" class="form-control input-md">
                      <!--<span class="help-block">Type de conditionnement</span>  -->
                      </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="dateCond">Date conditionnement</label>
                      <div class="col-md-4">
                        <input id="dateCond" name="dateCond" type="date" placeholder="Date conditionnement" class="form-control input-md">
                        <!--<span class="help-block">Entrez votre mot de passe (6 caractères minimum)</span>-->
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="dateLivraison">Date livraison</label>  
                      <div class="col-md-4">
                      <input id="dateLivraison" name="dateLivraison" type="date" placeholder="Date livraison" class="form-control input-md">
                      <!--<span class="help-block">Entrez votre adresse</span>  -->
                      </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="button"></label>
                      <div class="col-md-4">
                        <button id="button" name="validerCommande" class="btn btn-warning">Valider la commande</button><br>
                         <?php echo $erreur; ?>
                      </div>
                    </div>

                    </fieldset>
                </form>
            </div>
        </div>
	</div>
    
<br><br><br><br>
<footer class="container-fluid">
    <p class="text-center copyright">AGRUR<br> © Copyright 2017 // DUBRULLE / OSTROWSKI / GIAQUINTO</p>
</footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>