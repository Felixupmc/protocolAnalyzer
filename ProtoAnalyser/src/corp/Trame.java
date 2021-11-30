package pobj;

import java.util.StringJoiner;
import pobj.champs.Couche7;
import pobj.champs.DHCP;
import pobj.champs.DNS;
import pobj.champs.Ethernet;
import pobj.champs.IP;
import pobj.champs.UDP;

public class Trame{
	Ethernet eth;
	IP ip;
	UDP udp;
	Couche7 d;
	
	public Trame(Donnees donnees) {
		try {
			// Initialisation des champs
			eth= new Ethernet(donnees);
			ip = new IP(donnees.subDonnees(14));
			udp = new UDP(donnees);
			// On regarde les numéros de port Source et Destination
			int portSrc= udp.getPortSrc();
			int portDest= udp.getPortDest();
			// On verifie si on utilise DNS ou DHCP
			if (portSrc==53 || portDest ==53)
				d= new DNS(donnees);
			else {
				if (portSrc==67 || portDest ==67)
					d= new DHCP(donnees);
				else throw new Exception();
			}
		}
		catch( Exception e) {
			System.out.println("Fichier invalide");
		}
	}
	
	public String toString() {
		StringJoiner sb = new StringJoiner("\n");
		sb.add(eth.toString());
		sb.add(ip.toString());
		sb.add(udp.toString());
		sb.add(d.toString());
		return sb.toString();	}
}
