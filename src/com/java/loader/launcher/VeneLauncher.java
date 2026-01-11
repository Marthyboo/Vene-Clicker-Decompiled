package com.java.loader.launcher;

import com.java.loader.ConfigManager;
import com.java.loader.ShutdownHook;
import com.java.loader.gui.MainFrame;
import com.java.loader.listener.GlobalKeyListener;
import com.java.loader.listener.GlobalMouseListener;
import com.java.loader.state.VeneState;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;

public class VeneLauncher {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        VeneState.isJar = !VeneLauncher.class.getResource("VeneLauncher.class").toString().startsWith("file:");
        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));
        
        ConfigManager.loadConfig();
        
        MainFrame frame = new MainFrame();
        frame.setVisible(true);

        // Setup JNativeHook
        LogManager.getLogManager().reset();
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);

        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeMouseListener(new GlobalMouseListener());
        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
    }
}
