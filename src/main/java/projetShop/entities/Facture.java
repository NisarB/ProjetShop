package projetShop.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Facture {
	private double tva ;
	private payType typePaiement;
	private double remise;
	private Client client;
}