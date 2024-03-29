
package co.unicauca.hyunseda.presentation;

import co.unicauca.hyunseda.domain.entities.ItemShoppingCart;
import co.unicauca.hyunseda.domain.entities.Product;
import co.unicauca.hyunseda.domain.services.ShoppingCartService;
import co.unicauca.hyunseda.infra.Observer;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oscar
 */
public class GUICart extends javax.swing.JFrame implements Observer{
    private Product product;
    private int amount;
    
    private ShoppingCartService shoppingCartService;
    
    public GUICart(ShoppingCartService shoppingCartService){
        initComponents();
        this.shoppingCartService = shoppingCartService;
        setLocationRelativeTo(null); //centrar al ventana
    }
    
    private void initializeTable() {
        tblProductsCart.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name", "Amount"
                }
        ));
    }
    
    private void fillTable(List<Product> listProducts) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProductsCart.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();

            model.addRow(rowData);
        }
    }
    
    private void fillTableCart(List<ItemShoppingCart> listItemShoppingCart) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProductsCart.getModel();

        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listItemShoppingCart.size(); i++) {
            rowData[0] = listItemShoppingCart.get(i).getProduct().getProductId();
            rowData[1] = listItemShoppingCart.get(i).getProduct().getName();
            rowData[2] = listItemShoppingCart.get(i).getAmount();

            model.addRow(rowData);
        }
    }
    //--------------------------------------------------------------------------Tal vez, solo recibe uno
    private void fillTable(Product product) {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProductsCart.getModel();

        Object rowData[] = new Object[3];//No columnas
        rowData[0] = product.getProductId();
        rowData[1] = product.getName();
        rowData[2] = product.getDescription();

        model.addRow(rowData);
    }
    public GUICart() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductsCart = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);

        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPay);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("C A R T");
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        tblProductsCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProductsCart);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        new GUIPago(shoppingCartService.getShoppingCart()).setVisible(true);
  
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        shoppingCartService.cleanShoppingCart();
        this.shoppingCartService.getShoppingCart();
    }//GEN-LAST:event_btnCancelActionPerformed

    @Override
    public void update(Object o) {
        ShoppingCartService userServiceLocal = (ShoppingCartService) o;
        fillTableCart(userServiceLocal.getShoppingCart());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPay;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductsCart;
    // End of variables declaration//GEN-END:variables
}
