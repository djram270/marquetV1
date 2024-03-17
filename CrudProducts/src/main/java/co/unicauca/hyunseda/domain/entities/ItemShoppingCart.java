
package co.unicauca.hyunseda.domain.entities;

public class ItemShoppingCart {
    private Product product;
    private int amount;
    
    public ItemShoppingCart() {
        this.product = new Product();
        this.amount = 0;
    }

    public ItemShoppingCart(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
