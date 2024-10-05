
package ma.projet.test;
import java.util.Date;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;

import ma.projet.services.EmployeService;
import ma.projet.services.MessageService;
public class Messagerie {
    public static void main(String[] args) {
 //Teste Employe
EmployeService es = new EmployeService();
//Création des employes
es.create(new Employe("LACHGAR", "Mohamed"));
es.create(new Employe("RAMI", "ALI"));
es.create(new Employe("SAFI", "Fatima"));
//Modification d'un employe
Employe e = es.getById(24);
if (e != null) {
e.setNom("ALAOUI");
e.setPrenom("Manale");
es.update(e);
}
//Suppression d'un employe
//es.delete(es.getById(25));
//Liste des employes
for(Employe emp : es.getAll())
System.out.println(""+emp.getNom());
//Teste Message
EmployeService ee = new EmployeService();
MessageService ms = new MessageService();
ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(),
ee.getById(24), es.getById(26)));
ms.create(new Message("Réunion", "Réunion de fin d'année", new Date(),
ee.getById(24), es.getById(27)));
ms.create(new Message("Stage", "Stage à Marrakech", new Date(),
ee.getById(26), es.getById(24)));
ms.create(new Message("Stage", "Stage à Marrakech", new Date(),
ee.getById(24), es.getById(27)));
//Les message reçus par l'employé 3
for (Message m : ms.getAll()) {
if(m.getEmpRecepteur().getId() == 27)
System.out.println(""+m.getSujet());
}
}
    }