package com.java.loader;

import com.java.loader.state.VeneState;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public final class ConfigManager {
    private static File configFile;
    private static PrintWriter writer;

    static {
        configFile = new File("config.txt");
        try {
            configFile.createNewFile();
            writer = new PrintWriter(new FileOutputStream(configFile, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveConfig() {
        try {
            writer = new PrintWriter(configFile, "UTF-8");
            
            StringBuilder keybindsStr = new StringBuilder();
            if (VeneState.keybinds != null && !VeneState.keybinds.isEmpty()) {
                for (int i = 0; i < VeneState.keybinds.size(); i++) {
                    keybindsStr.append(VeneState.keybinds.get(i));
                    if (i < VeneState.keybinds.size() - 1) {
                        keybindsStr.append(":");
                    }
                }
            }
            
            writer.print(keybindsStr.toString() + ",");
            writer.print(VeneState.minCps + ",");
            writer.print(VeneState.maxCps + ",");
            writer.print(VeneState.cpsDropsEnabled + ",");
            writer.print(VeneState.jitterEnabled + ",");
            writer.print(VeneState.jitterX + ",");
            writer.print(VeneState.jitterY + ",");
            writer.print(VeneState.enabled + ","); // or is this c.a?
            writer.print(VeneState.someConfigValue + ",");
            writer.print(VeneState.anotherConfigValue);
            writer.println();
            writer.flush();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void loadConfig() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(configFile, "UTF-8");
        } catch (FileNotFoundException e) {
            VeneState.resetToDefaults();
            return;
        }

        if (!scanner.hasNextLine()) {
            VeneState.resetToDefaults();
            return;
        }

        String line = scanner.nextLine();
        if (line == null || line.isEmpty()) {
            VeneState.resetToDefaults();
            return;
        }

        String[] parts = line.split(",");
        try {
            VeneState.keybinds.clear();
            if (parts[0].contains(":")) {
                String[] keys = parts[0].split(":");
                for (String key : keys) {
                    VeneState.keybinds.add(Integer.parseInt(key));
                }
            } else if (!parts[0].isEmpty()){
                VeneState.keybinds.add(Integer.parseInt(parts[0]));
            }

            VeneState.minCps = Integer.parseInt(parts[1]);
            VeneState.maxCps = Integer.parseInt(parts[2]);
            VeneState.cpsDropsEnabled = Boolean.parseBoolean(parts[3]);
            VeneState.jitterEnabled = Boolean.parseBoolean(parts[4]);
            VeneState.jitterX = Integer.parseInt(parts[5]);
            VeneState.jitterY = Integer.parseInt(parts[6]);
            VeneState.enabled = Boolean.parseBoolean(parts[7]);
            VeneState.someConfigValue = Integer.parseInt(parts[8]);
            VeneState.anotherConfigValue = Integer.parseInt(parts[9]);
        } catch (Exception e) {
            VeneState.resetToDefaults();
        } finally {
            if (scanner != null) scanner.close();
        }
    }
}
