/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.hyunseda.plugin.manager;

import com.mycompany.commonhyunseda.IPayPlugin;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es una fábrica que utiliza reflexión para crear dinámicamente los
 * plugins.
 *
 */
public class PaymentPluginManager {

    private static final String FILE_NAME = "plugin.properties";
    private static PaymentPluginManager instance;

    private Properties pluginProperties;

    private PaymentPluginManager() {
        pluginProperties = new Properties();
    }

    public static PaymentPluginManager getInstance() {
        return instance;
    }

    public static void init(String basePath) throws Exception {
        instance = new PaymentPluginManager();
        instance.loadProperties(basePath);
        if (instance.pluginProperties.isEmpty()) {
            throw new Exception("Could not initialize plugins");
        }

    }

    public IPayPlugin getDeliveryPlugin(String payCode) {

        //Verificar si existe una entrada en el archivo para el metodo de pago indicado.
        String propertyName = "payment." + payCode.toLowerCase();
        if (!pluginProperties.containsKey(propertyName)) {
            return null;
        }

        IPayPlugin plugin = null;
        //Obtener el nombre de la clase del plugin.
        String pluginClassName = pluginProperties.getProperty(propertyName);
        try {

            //Obtener una referencia al tipo de la clase del plugin.
            Class<?> pluginClass = Class.forName(pluginClassName);
            if (pluginClass != null) {

                //Crear un nuevo objeto del plugin.
                Object pluginObject = pluginClass.getDeclaredConstructor().newInstance();

                if (pluginObject instanceof IPayPlugin) {
                    plugin = (IPayPlugin) pluginObject;
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            Logger.getLogger("PaymentPluginManager").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }

        return plugin;

    }

    private void loadProperties(String basePath) {

        String filePath = basePath + FILE_NAME;
        //System.out.println("path: " + filePath);
        try (FileInputStream stream = new FileInputStream(filePath)) {
            pluginProperties.load(stream);

        } catch (IOException ex) {
            Logger.getLogger("PaymentPluginManager").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }

    }

}
