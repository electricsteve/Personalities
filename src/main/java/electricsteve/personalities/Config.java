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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Config {


    public static List<String> checkIncorrectConfig() {
        FileConfiguration config = Personalities.getPlugin().getConfig();
        List<String> IncorrectConfigSettings = new ArrayList<String>();
        String[] CorrectPGOJ = new String[] {"random", "*REPLACE*"};

        if (Arrays.stream(CorrectPGOJ).noneMatch(Objects.requireNonNull(config.getString("personality-given-on-join"))::equals)) IncorrectConfigSettings.add("personality-given-on-join");

        return IncorrectConfigSettings;
    }
}
