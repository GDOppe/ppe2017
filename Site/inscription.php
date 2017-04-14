<?php

session_start();

//Connexion à la base de données
$bdd = new PDO('mysql:host=localhost;dbname=ppe;charset=utf8', 'root', 'root');

$erreur="";

if(isset($_POST['validerInscription'])){

  $nom = $_POST['nom'];
  $prenom= $_POST['prenom'];
  $mail=$_POST['mail'];
  $mdp = $_POST['mdp'];
  $adresse = $_POST['adresse'];
  $tel=$_POST['tel'];


  if(!empty($nom) && !empty($prenom) && !empty($mail) && !empty($mdp) && !empty($adresse) && !empty($tel)){

    if(strlen($mdp)>6){

      $bdd->exec("INSERT INTO client(nom, prenom, mail, adresse, tel) VALUES('$nom', '$prenom', '$mail', '$adresse', '$tel')");
      $bdd->exec("INSERT INTO membre(mail, mdp, role) VALUES('$mail', '$mdp', '0')");
      header("Location: connexion.php");
      exit();
    }
    else{
      $erreur = "Votre mot de passe est trop court";
    }

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
                <form action="inscription.php" class="form-horizontal" method="post">
                    <fieldset>

                    <!-- Form Name -->
                    <h3 class="center_title"><b>INSCRIPTION</b></h3>
                    <hr class="black_hr">
                    <br>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="nom">Nom</label>  
                      <div class="col-md-4">
                      <input id="nom" name="nom" type="text" placeholder="Nom" class="form-control input-md">
                      <span class="help-block">Entrez votre nom</span>  
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="prenom">Prenom</label>  
                      <div class="col-md-4">
                      <input id="prenom" name="prenom" type="text" placeholder="Prenom" class="form-control input-md">
                      <span class="help-block">Entrez votre prenom</span>  
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="mail">Email</label>  
                      <div class="col-md-4">
                      <input id="mail" name="mail" type="text" placeholder="Email" class="form-control input-md">
                      <span class="help-block">Entrez votre Email</span>  
                      </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="mdp">Mot de passe</label>
                      <div class="col-md-4">
                        <input id="mdp" name="mdp" type="password" placeholder="Mot de passe" class="form-control input-md">
                        <span class="help-block">Entrez votre mot de passe (6 caractères minimum)</span>
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="adresse">Adresse</label>  
                      <div class="col-md-4">
                      <input id="adresse" name="adresse" type="text" placeholder="Adresse" class="form-control input-md">
                      <span class="help-block">Entrez votre adresse</span>  
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="tel">Telephone</label>  
                      <div class="col-md-4">
                      <input id="tel" name="tel" type="text" placeholder="Telephone" class="form-control input-md">
                      <span class="help-block">Entrez vote numéro de téléphone</span>  
                      </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="button"></label>
                      <div class="col-md-4">
                        <button id="button" name="validerInscription" class="btn btn-warning">Inscription</button><br>
                         <?php echo $erreur; ?> 
                        <a href="connexion.php">Vous avez déjà un compte ? </a>
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