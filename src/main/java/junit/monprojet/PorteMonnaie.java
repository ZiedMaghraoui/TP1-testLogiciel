package junit.monprojet;

import java.util.HashMap;
import java.util.Map;

public class PorteMonnaie {
    private HashMap<String, Integer> contenu;

    public HashMap<String, Integer> getContenu() {
        return contenu;
    }

    public PorteMonnaie() {
        contenu = new HashMap<String, Integer>();
    }

    public void ajouteSomme(SommeArgent sa) {
        String unite = sa.getUnite();
        if (!contenu.containsKey(unite)) {
            contenu.put(unite, sa.getQuantite());
        } else {
            int somme = contenu.get(unite);
            somme += sa.getQuantite();
            contenu.put(unite, somme);
        }
    }

    public String toString() {
        String result = "{PorteMonnaie: ";
        for (Map.Entry<String, Integer> entry : contenu.entrySet()) {
            result += entry.getKey() + entry.getValue() + ", ";
        }
        result += "}";
        return result;
    }
}
