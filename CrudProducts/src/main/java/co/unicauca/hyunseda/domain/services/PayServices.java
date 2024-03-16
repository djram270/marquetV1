/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.domain.services;

import co.unicauca.hyunseda.plugin.manager.PaymentPluginManager;
import com.mycompany.commonhyunseda.IPayPlugin;
import com.mycompany.commonhyunseda.Payment;

/**
 *
 * @author Oscar
 */
public class PayServices {
    
    //verifica si el metodo de pago es correcto o si la cuenta tiene saldo sugiciente para el cargo que se le va a realizar
    public boolean verifyPayment(Payment payment) throws Exception {
        String typePayment = payment.getTypePayment();
        PaymentPluginManager manager = PaymentPluginManager.getInstance();
        IPayPlugin plugin = manager.getDeliveryPlugin(typePayment);

        if (plugin == null) {
            throw new Exception("No hay un plugin disponible para el metodo de pago escogido: " + typePayment);
        }

        return plugin.pay(payment);

    }
}
