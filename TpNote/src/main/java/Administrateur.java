import java.util.List;

public class Administrateur extends Employe {
	
	
	public Administrateur(Agence a,Entreprise e) {
		super(a, e);
	
		
	}
	
	public boolean attribuerMateriel(Empruntable empruntable, Emprunteur emprunteur) {
		return emprunteur.stock.add(empruntable);
	}
	
	public boolean recupererMateriel (Empruntable empruntable, Emprunteur emprunteur) {
		return emprunteur.stock.remove(empruntable);
	}
	
	public List<Empruntable> stockEntreprise(){
		return getEntreprise().listeMateriel();
		
	}
	
	public List<Empruntable> stockAgence(){
		// A REVOIR
		return getAgence().listeMateriel();
		
	}
	
	public void transfererMateriel(Empruntable empruntable, Emprunteur emprunteur1,Emprunteur emprunteur2) {
		emprunteur1.stock.remove(empruntable);
		emprunteur2.stock.add(empruntable);
	}
	
	public void supprimerMateriel(Empruntable e) {
		getEntreprise().listeMateriel().remove(e);
	}
	
	public void supprimerMaterielDefectueuxEntreprise() {
		for(Empruntable e: getEntreprise().listeMateriel() ) {
			if(e.defectueux) {
				getEntreprise().listeMateriel().remove(e);
			}
		}
		
	}
	
	public void supprimerMaterielDefectueuxAgence(Agence a) {
		for(Empruntable e: getAgence().listeMateriel() ) {
			if(e.defectueux) {
				getAgence().listeMateriel().remove(e);
			}
		}
	}
	
	public void supprimerMaterielDefectueuxDe(Emprunteur e) {
		for(Empruntable emp: e.listeMateriel() ) {
			if(emp.defectueux) {
				e.listeMateriel().remove(e);
			}
		}
	}
	
}