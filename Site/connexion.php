<?php

session_start();

//Connexion à la base de données
$bdd = new PDO('mysql:host=localhost;dbname=ppe;charset=utf8', 'root', 'root');

$erreur="";



//Connexion d'un membre
if(isset($_POST['connexion'])){
    //Récupération des variables php
    
    $mail= htmlspecialchars($_POST['mail']);
    $_SESSION['mail'] = $mail;
    $mdp = $_POST['mdp'];
    
    if(!empty($mail) && !empty($mdp)){

        $req=$bdd->query('SELECT mail, mdp, role FROM membre WHERE mail =\''.$mail.'\' and mdp = \''.$mdp.'\'');
        $nbr = $req->rowCount();

        while($tab = $req->fetch()){
            // Si le couple identifiant/mdp est bon
            if($tab['role'] == 1){
                //Si l'utilisateur est un producteur
                header('Location: view_pro.php');
                exit();
            }
            if($tab['role'] == 2){
                //Si l'utilisateur est un administrateur
                header('Location: view_admin.php');
                exit();
            }
            else{
                //Si l'utilisateur est un Client
                header('Location: view_user.php');
                exit();
            }
        }

        if($nbr==0){
            $erreur="Mauvais identifiant ou mdp";
        }
    }
    else {
        // Si un des champs est vide
        $erreur= "Tous les champs doivent être complétés !";
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
                <form action="connexion.php" class="form-horizontal" method="post">
                <fieldset>

                <!-- Form Name -->
                <h3 class="center_title"><b>CONNEXION</b></h3>
                <hr class="black_hr">
                <br>

                <!-- Text input-->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="mail">Email</label>  
                  <div class="col-md-4">
                  <input id="mail" name="mail" type="email" placeholder="Email" class="form-control input-md">
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

                <!-- Button -->
                <div class="form-group">
                  <label class="col-md-4 control-label" for="button"></label>
                  <div class="col-md-4">
                    <button id="button" name="connexion" class="btn btn-warning">Connexion</button><br>
                    <?php echo $erreur; ?>
                    <a href="inscription.php">Vous n'avez pas encore de compte ? </a>
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