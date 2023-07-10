/*
 * MIT License
 *
 * Copyright (c) 2023 ElectricSteve
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package electricsteve.personalities;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.List;
import java.util.logging.Level;

public final class Personalities extends JavaPlugin{
    private static Personalities plugin;
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        plugin = this;
        File configFile = new File(getDataFolder(), "config.yml");

        LogInfo("Personalities is loading...");
        LogInfo("Loading config.");
        config.addDefault("enable-personality-on-join", true);
        config.addDefault("personality-given-on-join", "random");
        if (!(configFile.exists()) || configFile.length() == 0) saveDefaultConfig();
        saveConfig();
        LogInfo(String.valueOf(configFile.length()));
        List<String> IncorrectConfigSettings = Config.checkIncorrectConfig();
        if (!(IncorrectConfigSettings.isEmpty())) LogWarning("Incorrect config options:" + IncorrectConfigSettings.toString() + "These config options are incorrect and are reset to their defaults.");
        LogInfo("Config loaded.");
        LogInfo("Personalities loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void LogInfo(String msg) {
        plugin.getLogger().log(Level.INFO, msg);
    }

    private void LogWarning(String msg) {
        plugin.getLogger().log(Level.WARNING, msg);
    }

    public static Personalities getPlugin() {
        return plugin;
    }
}
