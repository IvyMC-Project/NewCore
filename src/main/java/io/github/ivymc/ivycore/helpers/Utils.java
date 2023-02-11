package io.github.ivymc.ivycore.helpers;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@SuppressWarnings("unused")
public class Utils {
    public static <T> Optional<T> getRandomOrEmpty(List<T> list, Random random) {
        return list.isEmpty() ? Optional.empty() : Optional.of(getRandom(list, random));
    }

    public static <T> T getRandom(List<T> list, Random random) {
        return list.get(random.nextInt(list.size()));
    }
}
