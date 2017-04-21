
<?php

session_start();

//Connexion à la base de données
$bdd = new PDO('mysql:host=localhost;dbname=vdev;charset=utf8', 'root', 'root');

$erreur="";

$mail = $_SESSION['mail'];

$sqlNomProd = $bdd->query('SELECT nom FROM producteur WHERE mail = \''.$mail.'\'');
$tab = $sqlNomProd->fetch();

$nomProd = $tab['nom'];

if(isset($_POST['validerVergers'])){

  $nom = $_POST['nomVer'];
  $superficie= $_POST['superficie'];
  $densite=$_POST['densite'];
  $varieteNoix = $_POST['varieteNoix'];
  $calibre = $_POST['calibre'];
  $commune=$_POST['commune'];


  if(!empty($nom) && !empty($superficie) && !empty($densite) && !empty($varieteNoix) && !empty($calibre) && !empty($commune)){


    $bdd->exec("INSERT INTO vergers(nom, nomProd, superficie, densite, varieteNoix, calibre, commune) VALUES('$nom', '$nomProd', $superficie, $densite, '$varieteNoix', $calibre, '$commune')");
    header("Location: view_pro.php");
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
                    
                </li>
            	</ul>
        	</div>
    	</div>
	</header>
	
		<img class="img_titre" src="style/titre.png">
	
    <div class="container">
        <div class="row">
            <div class="block_inscription">
                <form action="ajouterVergers.php" class="form-horizontal" method="post">
                    <fieldset>

                    <!-- Form Name -->
                    <h3 class="center_title"><b>Ajout d'un vergers</b></h3>
                    <hr class="black_hr">
                    <br>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="nomVer">Nom du vergers : </label>  
                      <div class="col-md-4">
                      <input id="nomVer" name="nomVer" type="text" placeholder="Nom" class="form-control input-md">
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="superficie"> Superficie du vergers : (en ha)</label>  
                      <div class="col-md-4">
                      <input id="superficie" name="superficie" type="text" placeholder="Superficie" class="form-control input-md">
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="densite"> Densité du vergers : (en m²)</label>  
                      <div class="col-md-4">
                      <input id="densite" name="densite" type="text" placeholder="Densité" class="form-control input-md"> 
                      </div>
                    </div>

                    <!-- Password input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="varieteNoix"> Variété des noix : </label>
                      <div class="col-md-4">
                        <input id="varieteNoix" name="varieteNoix" type="text" placeholder="Variété" class="form-control input-md">
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="calibre"> Calibre des noix : (en mm)</label>  
                      <div class="col-md-4">
                      <input id="calibre" name="calibre" type="text" placeholder="Taille " class="form-control input-md"> 
                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="commune">Commune du vergers : </label>  
                      <div class="col-md-4">
                      <input id="commune" name="commune" type="text" placeholder="Commune" class="form-control input-md">
                      </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                      <label class="col-md-4 control-label" for="button"></label>
                      <div class="col-md-4">
                        <button id="button" name="validerVergers" class="btn btn-warning">Valider le vergers</button><br>
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