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
            result += entry.getValue() + entry.getKey() + ", ";
        }
        result += "}";
        return result;
    }

    public boolean equals(Object anObject) {
//        check if instance
        if (!(anObject instanceof PorteMonnaie)) return false;
//        check if same currencies
        PorteMonnaie pm = (PorteMonnaie) anObject;
        if (!contenu.keySet().equals(pm.getContenu().keySet())) return false;
//        check if same amounts
        boolean res = true;
        for (Map.Entry<String, Integer> entry : contenu.entrySet()) {
            String key = entry.getKey();
            Integer value1 = entry.getValue();
            Integer value2 = pm.getContenu().get(key);

            if (!value1.equals(value2)) {
                res = false;
                break;
            }
        }
        return res;
    }
}
