package food.blockchain;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hien
 */
public class FoodBlockChainTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Store kfc = new Store("KFC Vietnam", null);
        Store burger = new Store("Burger King", kfc);
        Store pho = new Store("Pho", kfc);
        
        Store[] stores = {kfc, burger, pho};
        
        for (Store store : stores) {
            Thread thread = new Thread(store);
            thread.start();
        }
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FoodBlockChainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Store store : stores) {
            System.out.println("");
            store.printBlockChain();
        }
    }
    
}
