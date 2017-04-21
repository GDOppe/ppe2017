<?php

session_start();

$bdd = new PDO('mysql:host=localhost;dbname=vdev;charset=utf8', 'root', 'root');

$nom = $_GET['nom'];
$erreur="";

if(isset($_POST['validerAdhesion'])){

    $adhesion=$_POST['adhesion'];
    $dateAdhesion = $_POST['dateAdhesion'];

    if(!empty($adhesion)){
        if($adhesion == "oui" && !empty($dateAdhesion)){
            $req = $bdd->prepare('UPDATE producteur SET dateAdherent= :dateAdherent WHERE nom= :nom');
            $req->execute(array(
                'dateAdherent'=>$dateAdhesion,
                'nom'=>$nom
            ));
            header('Location: view_admin.php');
        }
    }
    else{
        $erreur = "Vous devez au moins remplir la sélection d'adhésion ";
    }
}
if(isset($_POST['validerCertification'])){

    $certif=$_POST['certif'];

    if(!empty($certif)){
        if($certif=="bio"){
            $req = $bdd->prepare('UPDATE producteur SET idCertif= 1 WHERE nom= :nom');
            $req->execute(array(
                'nom'=>$nom
            ));
            header('Location: view_admin.php');
        }
        else{
            $req = $bdd->prepare('UPDATE producteur SET idCertif= 0 WHERE nom= :nom');
            $req->execute(array(
                'nom'=>$nom
            ));
            header('Location: view_admin.php');
        }
    }
    else{
        $erreur = "Vous devez au moins remplir la sélection d'adhésion ";
    }
}

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
            <h3 class="center_title"><b>MODIFICATIONS DES INFORMATIONS</b></h3>
            <br>
            
                <hr class="black_hr">

                <div class="row">
                    <div class="col-md-6">
                        <h4 class="center_title"><b>Adhérent</b></h4>
                        
                        <div class="form-group">
                          <label class="col-md-16 control-label center" for="libelleAdhesion"> Est-ce que Mr <?php echo $nom; ?> est devenu adhérent ?   </label>

                            <input id="adhesion" name="adhesion" type="radio" value="oui" />
                            <label for="adhesion"> Oui </label>

                            <input id="adhesion" name="adhesion" type="radio" value="non" />
                            <label for="adhesion"> Non </label>

                            <br><br>

                            <div class="col-md-12">
                          
                                <label> Si oui, à quelle date ? </label>
                                <input id="dateAdhesion" name="dateAdhesion" type="date" placeholder="format AAAA-MM-JJ">

                            </div>
                        </div>
                        <br><br>

                        <div class="form-group">
                          <label class="col-md-4 control-label" for="button"></label>
                          <div class="col-md-4">
                            <button id="button" name="validerAdhesion" class="btn btn-warning">Valider l'adhésion </button><br>
                             <?php echo $erreur; ?>
                          </div>
                        </div>

                        <br><br>

                    </div>
                    <div class="col-md-6 ">
                        <h4 class="center_title"><b>Certification</b></h4>
                        <div class="form-group">
                          <label class="col-md-16 control-label center" for="libelleCertif"> Quelle certification possède Mr <?php echo $nom; ?> ?  </label>

                        <br><br>
                        <input id="certif" name="certif" type="radio" value="aucune" />
                        <label for="certif"> Aucune </label>

                        <input id="certif" name="certif" type="radio" value="bio" />
                        <label for="certif"> Agriculteur biologique </label>

                        <br><br>

                        <div class="form-group">
                          <label class="col-md-4 control-label" for="button"></label>
                          <div class="col-md-4">
                            <button id="button" name="validerCertification" class="btn btn-warning">Valider la certification</button><br>
                             <?php echo $erreur; ?>
                          </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
	</div>
    </form>
    <br><br><br>
    <footer class="container-fluid">
        <p class="text-center copyright">AGRUR<br> © Copyright 2017 // DUBRULLE / OSTROWSKI / GIAQUINTO</p>
    </footer>
</body>
</html>
