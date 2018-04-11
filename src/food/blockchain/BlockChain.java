package food.blockchain;

import java.util.ArrayList;

/**
 *
 * @author hien
 */
public class BlockChain implements Cloneable {
    private final ArrayList<Block> chain;
    
    public BlockChain() {
        this.chain = new ArrayList<>();
        this.chain.add(Block.getGenesisBlock());
    }
    
    public ArrayList<Block> getBlocks() {
        return (ArrayList<Block>) chain.clone();
    }
    
    public long size() {
        return chain.size();
    }
    
    public void add(Block block) {
        if (validateBlock(chain.get(chain.size() - 1), block)) {
            chain.add(block);
        } else {
            throw new IllegalArgumentException("Invalid block");
        }
    }
    
    public String getLastHash() {
        return this.chain.get(this.chain.size() - 1).hash;
    }
        
    public boolean validateBlock(Block previousBlock, Block block) {
        return block.previousHash.equals(previousBlock.hash);
    }
    
    public boolean validate() {        
        ArrayList<Block> subChain = (ArrayList<Block>) chain.subList(1, chain.size() - 1);
        Block previousBlock = chain.get(0);

        for (Block currentBlock : subChain) {
            if (!validateBlock(previousBlock, currentBlock)) {
                return false;
            }
            previousBlock = currentBlock;
        }
        
        return true;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
