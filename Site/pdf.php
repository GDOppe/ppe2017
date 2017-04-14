<?php
require('fpdf/fpdf.php');


class PDF extends FPDF
{

function Header()
{

    session_start();
    $bdd = new PDO('mysql:host=localhost;dbname=ppe;charset=utf8', 'root', 'root');


    $mail=$_SESSION['mail'];
    $idCommande=$_GET['idCommande'];

    // Police Arial gras 15
    $this->Image('style/titre.png',55,0,100,50);
    $this->SetFont('Arial','',10);
    $this->SetDrawColor(192,163,47);
    $this->Line(0,37,300,37);
    $this->ln(30);
    
    $this->ln(-10);
    $reqInfo = $bdd->query('SELECT nom, prenom, adresse, tel FROM client WHERE mail = \''.$mail.'\'');

    while($tab = $reqInfo->fetch()){
        $this->SetFont('Times','I');
        $this->Cell(10,30,utf8_decode("Coordonnées du client : "),0);
        $this->SetFont('Times','');
        $this->ln(7);
        $this->Cell(10);
        $this->Cell(10,30,utf8_decode("- ".$tab['nom']),0);
        $this->ln(7);
        $this->Cell(10);
        $this->Cell(10,30,utf8_decode("- ".$tab['prenom']),0);
        $this->ln(7);
        $this->Cell(10);
        $this->Cell(10,30,utf8_decode("- ".$mail),0);
        $this->ln(7);
        $this->Cell(10);
        $this->Cell(10,30,utf8_decode("- ".$tab['tel']),0);
    }
    $this->ln(10);
    $this->Cell(105);
    
    $this->ln(-38);
    $this->Cell(100);
    $this->SetFont('Times','I');
    $this->Cell(10,30,utf8_decode("Coordonnées du producteur : "),0);
    $this->SetFont('Times','');

    $reqProd = $bdd->query('SELECT commande.nomProd, producteur.prenom, producteur.mail, producteur.tel FROM commande, producteur WHERE commande.nomProd=producteur.nom and commande.idCommande = \''.$idCommande.'\'');
    while($tab = $reqProd->fetch()){
        $this->ln(7);
        $this->Cell(110);
        $this->Cell(10,30,utf8_decode("- ".$tab['nomProd']),0);
        $this->ln(7);
        $this->Cell(110);
        $this->Cell(10,30,utf8_decode("- ".$tab['prenom']),0);
        $this->ln(7);
        $this->Cell(110);
        $this->Cell(10,30,utf8_decode("- ".$tab['mail']),0);
        $this->ln(7);
        $this->Cell(110);
        $this->Cell(10,30,utf8_decode("- ".$tab['tel']),0);
    }
    $this->ln(10);


    $this->Ln(30);
    $this->Line(0,90,300,90);

    //$this->Cell(0,60,"",1);
    $this->ln(-10);
    $this->Cell(80);
    $this->SetFont('Times','B');
    $this->Cell(10,30,utf8_decode("COMMANDE : ".$idCommande),0);
    $this->SetFont('Times','');
    $reqCommande = $bdd->query('SELECT varieteNoix, type, dateCond, dateLiv FROM commande WHERE idCommande = \''.$idCommande.'\'');
    $this->ln(15);
    while($tab = $reqCommande->fetch()){
        $this->Cell(25);
        $this->Cell(10,30,utf8_decode("- Variété de noix : ".$tab['varieteNoix']),0);
        $this->ln(10);
        $this->Cell(25);
        $this->Cell(10,30,utf8_decode("- Type de conditionnement : ".$tab['type']),0);
        $this->ln(10);
        $this->Cell(25);
        $this->Cell(10,30,utf8_decode("- Date de conditionnement : ".$tab['dateCond']),0);
        $this->ln(10);
        $this->Cell(25);
        $this->Cell(10,30,utf8_decode("- Date de livraison : ".$tab['dateLiv']),0);
    }


    $this->Ln(50);
    $this->Cell(85,40,"",1);
    $this->ln(-10);
    $this->Cell(10,30,utf8_decode("Signature du client : "),0);
    $this->Image('style/signatureClient.jpg',15,190,70,30);
    $this->ln(10);
    $this->Cell(105);
    $this->Cell(85,40,"",1);
    $this->ln(-10);
    $this->Cell(105);
    $this->Cell(10,30,utf8_decode("Signature du producteur : "),0);
    $this->Image('style/signatureProd.jpg',130,190,70,30);
    $this->ln(10);
    
}

// Pied de page
function Footer()
{
    // Positionnement à 1,5 cm du bas
    $this->SetY(-15);
    // Police Arial italique 8
    $this->SetFont('Arial','I',7);
    // Bas de page
    $this->Cell(0,2,utf8_decode('AGRUR est une coopérative agricole spécialisée dans la collecte, la transformation et le conditionnement de la noix qualifiée "noix de Grenoble"'),0,0,'C');
    $this->ln(3);
    $this->Cell(0,2,utf8_decode('Les membres de la coopérative sont des producteurs situés dans la vallée de l\'Isère.'),0,0,'C');
    $this->Ln(3);
    $this->Cell(0,2,utf8_decode('AGRUR est engagée dans une démarche qualité et souhaite améliorer la traçabilité de ses produits.'),0,0,'C');
    $this->Ln(3);
    $this->Cell(0,2,utf8_decode('Elle envisage donc de réorganiser la partie de son système d\'information relative à la gestion des approvisionnements et des ventes.'),0,0,'C');
}
}

// Instanciation de la classe dérivée
$pdf = new PDF();
$pdf->SetFont('Arial','',10);

$pdf->SetFont('Times','',12);

$pdf->Output();

?>