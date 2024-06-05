package etudiant;

import java.util.ArrayList;
import java.util.Collections;


import jfc.ICalculateurPlusCourtChemin;
import jfc.Ville;
/**
 * Les instances de cette classe permette de calculer un plus court chemine entre deux villes en utilisant l'algorithme de Dijkstra.
 * @author Jean-François Condotta, 04 juin 2023.
 *
 */
public class CalculateurPlusCourtChemin implements ICalculateurPlusCourtChemin{

	@Override
	public ArrayList<Ville> plusCourtChemin(ArrayList<Ville> toutesLesVilles, Ville villeDepart, Ville villeArrivee) {

		ArrayList<Ville> chemin = new ArrayList<>();
		ArrayList<Ville> villesNonVisitees = new ArrayList<>(toutesLesVilles);
		ArrayList<Double> cout = new ArrayList<>(Collections.nCopies(toutesLesVilles.size(), Double.POSITIVE_INFINITY));
		ArrayList<Ville> predecesseur = new ArrayList<>(Collections.nCopies(toutesLesVilles.size(), null));

		cout.set(toutesLesVilles.indexOf(villeDepart), 0.0);

		while (!villesNonVisitees.isEmpty()) {
			Ville villeActuelle = null;
			double minCout = Double.POSITIVE_INFINITY;

			for (Ville ville : villesNonVisitees) {
				double villeCout = cout.get(toutesLesVilles.indexOf(ville));
				if (villeCout < minCout) {
					villeActuelle = ville;
					minCout = villeCout;
				}
			}

			if (villeActuelle.equals(villeArrivee)) {
				break;
			}

			villesNonVisitees.remove(villeActuelle);

			for (Ville villeVoisine : villeActuelle.getVillesVoisines()) {
				double coutPotentiel = cout.get(toutesLesVilles.indexOf(villeActuelle)) + villeActuelle.getDistanceMetres(villeVoisine);
				int indexVoisine = toutesLesVilles.indexOf(villeVoisine);

				if (coutPotentiel < cout.get(indexVoisine)) {
					cout.set(indexVoisine, coutPotentiel);
					predecesseur.set(indexVoisine, villeActuelle);
				}
			}
		}

		Ville villeActuelle = villeArrivee;
		while (villeActuelle != null) {
			chemin.add(0, villeActuelle);
			villeActuelle = predecesseur.get(toutesLesVilles.indexOf(villeActuelle));
		}

		return chemin;
	}
}
